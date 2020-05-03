package com.example.mybrower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MyBrowserActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mybrowser);
        webView = findViewById(R.id.webview);
        webView.loadUrl("https://www.baidu.com");
        Intent intent = getIntent();
        if (Intent.ACTION_VIEW.equals(intent.getAction())){
            String url=intent.getData().toString();
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(url);

        }

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                view.loadUrl(url);
                 return true;
            }
        });

    }
}
