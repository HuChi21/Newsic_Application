package com.example.android_nhom8.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_nhom8.MainActivity;
import com.example.android_nhom8.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://login-1fa3c-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText phone = this.<EditText>findViewById(R.id.phone);
        final EditText password = findViewById(R.id.password);
        final Button loginBtn = findViewById(R.id.loginbtn);
        final TextView registerNowBtn = findViewById(R.id.registerNowbtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String phonetxt = phone.getText().toString().trim();
                final String passwordtxt = password.getText().toString().trim();
                if (phonetxt.isEmpty() || passwordtxt.isEmpty()) {
                    Toast.makeText(login.this, "Please enter your mobile or pass word", Toast.LENGTH_SHORT).show();
                } else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //check mobile/phone không có trong firebase
                            if(snapshot.hasChild(phonetxt))
                            {
                                final String getPassword = snapshot.child(phonetxt).child("password").getValue(String.class);

                                if(getPassword.equals(passwordtxt))
                                {
                                    Toast.makeText(login.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                                    //đăng nhập thành công, chuyển đến Mainactivity
                                    startActivity(new Intent(login.this, MainActivity.class));
                                    finish();
                                }
                                else{
                                    Toast.makeText(login.this, "Wrong Phone or Password", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
        registerNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chuyển đến đăng ký activity
                startActivity(new Intent(login.this, register.class ));

            }
        });
    }
}