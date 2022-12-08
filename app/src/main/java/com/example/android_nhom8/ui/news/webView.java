package com.example.android_nhom8.ui.news;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.android_nhom8.R;

public class webView extends AppCompatActivity {
    Toolbar toolbar;
    WebView webView;
    ImageButton imageButton1;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_web_view);
        toolbar=findViewById(R.id.toolbar);
        webView=findViewById(R.id.webview);
        setSupportActionBar(toolbar);

        imageButton1=(ImageButton)findViewById(R.id.imgButton1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(webView.this,NewsActivity.class));
            }
        });

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}
