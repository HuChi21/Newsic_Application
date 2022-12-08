package com.example.android_nhom8.ui.profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.android_nhom8.MainActivity;
import com.example.android_nhom8.R;
import com.example.android_nhom8.ui.news.NewsActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class ProfileActivity extends AppCompatActivity {

    TextView txtName,txtPhone,txtEmail;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://login-1fa3c-default-rtdb.firebaseio.com/");
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtName = (TextView) findViewById(R.id.txtUserName);
        txtPhone = (TextView) findViewById(R.id.txtMobile);
        txtEmail = (TextView) findViewById(R.id.txtEmail);

        imageButton=(ImageButton)findViewById(R.id.imgButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            }
        });

        //User 0
        user0();

        //User 098765421:
        user098765421();

        //User 0981
        user0981();

    }

    private void user0981() {
        databaseReference.child("users/0981/fullname").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String string = snapshot.getValue(String.class);
                txtName.setText(string);
                txtPhone.setText("0981");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        databaseReference.child("users/0981/email").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String string = snapshot.getValue(String.class);
                txtEmail.setText(string);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void user098765421() {
        databaseReference.child("users/098765421/fullname").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String string = snapshot.getValue(String.class);
                txtName.setText(string);
                txtPhone.setText("098765421");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        databaseReference.child("users/098765421/email").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String string = snapshot.getValue(String.class);
                txtEmail.setText(string);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void user0() {
        databaseReference.child("users/0/fullname").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String string = snapshot.getValue(String.class);
                txtName.setText(string);
                txtPhone.setText("string");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        databaseReference.child("users/0/email").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String string = snapshot.getValue(String.class);
                txtEmail.setText(string);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}