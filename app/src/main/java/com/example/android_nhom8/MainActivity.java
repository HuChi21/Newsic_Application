package com.example.android_nhom8;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.example.android_nhom8.login.login;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_nhom8.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    TextView txtMobi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        supportOnClick();

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_profile,R.id.nav_news,R.id.nav_music,R.id.nav_youtube)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuAbout:
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
                return true;

            case R.id.menuExit:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you want to Logout?").setCancelable(false).setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent2 = new Intent(MainActivity.this, login.class);
                        startActivity(intent2);
                    }
                }).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        System.exit(0);
                    }
                }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.setTitle("Logout");
                alertDialog.show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
    public void supportOnClick(){
        binding.appBarMain.fabPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tel="0934810941";
                Intent intent1 = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", tel,null));
                startActivity(intent1);
            }
        });

        binding.appBarMain.fabGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail="newsic.customersup@gmail.com";
                String password="asdasd@12";
                Intent intent2 = new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto",mail,null));
                startActivity(intent2);
            }
        });
        binding.appBarMain.fabMessager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FbUserID="zlbkz";
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://messaging/" + FbUserID));
                startActivity(intent3);
            }
        });

    }
}