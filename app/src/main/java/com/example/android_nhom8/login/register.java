package com.example.android_nhom8.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_nhom8.R;
import com.example.android_nhom8.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Pattern;

public class register extends AppCompatActivity implements View.OnClickListener{

    private EditText fullname,email,phone,password,conPassword;

    private TextView txtLoginNow;
    private Button btnRegister;
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fullname =(EditText) findViewById(R.id.fullname);
        email =(EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        password =(EditText) findViewById(R.id.password);
        conPassword =(EditText) findViewById(R.id.conPassword);

        btnRegister = findViewById(R.id.btnRegister);
        txtLoginNow = findViewById(R.id.txtLoginNow);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        firebaseAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(this);
        txtLoginNow.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case(R.id.txtLoginNow):
                onBackPressed();
                break;
            case(R.id.btnRegister):
                registerUser();

                break;
        }
    }

    private void registerUser() {
        String txtFullname = fullname.getText().toString().trim();
        String txtEmail = email.getText().toString().trim();
        String txtPhone = phone.getText().toString().trim();
        String txtPassword = password.getText().toString().trim();
        String txtConPassword = conPassword.getText().toString().trim();

        if(txtFullname.isEmpty()){
            fullname.setError("Fullname is required!");
            fullname.requestFocus();
            return;
        }
        if(txtEmail.isEmpty()){
            email.setError("Email is required!");
            email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(txtEmail).matches()){
            email.setError("Please provide valid Email!");
            email.requestFocus();
            return;
        }
        if(txtPhone.isEmpty()){
            phone.setError("Phone is required!");
            phone.requestFocus();
            return;
        }
        if(txtPassword.isEmpty()){
            password.setError("Password is required!");
            password.requestFocus();
            return;
        }
        if(txtConPassword.isEmpty()) {
            conPassword.setError("Confirm Password is required!");
            conPassword.requestFocus();
            return;
        }
        if(!txtConPassword.equals(txtPassword)){
            conPassword.setError("Password & Confirm Password aren't meet!");
            conPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        firebaseAuth.createUserWithEmailAndPassword(txtEmail,txtPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    User user = new User(txtFullname,txtPhone,txtEmail);
                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                   if(task.isSuccessful()) {
                                       Toast.makeText(register.this, "Registered successfully!", Toast.LENGTH_SHORT).show();
                                       progressBar.setVisibility(View.GONE);

                                   }
                                   else{
                                       Toast.makeText(register.this, "Failed to register!", Toast.LENGTH_SHORT).show();
                                       progressBar.setVisibility(View.GONE);
                                   }
                                }
                            });

                        }
                else{
                    Toast.makeText(register.this, "Failed to register!", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }


}

