package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText url_text;
    private Button check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url_text = findViewById(R.id.url);
        check = findViewById(R.id.check);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = url_text.getText().toString();
                Uri content_url = Uri.parse(url);
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_VIEW);
                sendIntent.setData(content_url);
                startActivity(sendIntent);
            }
        });
    }
}
