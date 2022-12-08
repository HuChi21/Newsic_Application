package com.example.android_nhom8.ui.news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.android_nhom8.MainActivity;
import com.example.android_nhom8.R;
import com.example.android_nhom8.login.login;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class NewsActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem thome,tBusiness,tEntertainment,tGeneral,tHealth,tScience,tSports,tTech;
    PagerAdapter pagerAdapter;
    Toolbar ttoolbar;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ttoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(ttoolbar);

        imageButton=(ImageButton)findViewById(R.id.imgButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewsActivity.this, MainActivity.class));
                finish();
            }
        });

        thome=findViewById(R.id.home);
        tBusiness=findViewById(R.id.business);
        tEntertainment=findViewById(R.id.entertainment);
        tGeneral =findViewById(R.id.general);
        tHealth=findViewById(R.id.health);
        tScience=findViewById(R.id.science);
        tSports=findViewById(R.id.sports);
        tTech=findViewById(R.id.technology);

        ViewPager viewPager = findViewById(R.id.container);
        tabLayout=findViewById(R.id.included);

        pagerAdapter = new com.example.android_nhom8.ui.news.PagerAdapter(getSupportFragmentManager(),8);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5||tab.getPosition()==6||tab.getPosition()==7)
                {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }


}