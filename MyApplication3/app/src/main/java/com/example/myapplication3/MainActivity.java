package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button simpleAdapter_btn = (Button) findViewById(R.id.simpleadapter_btn);
        simpleAdapter_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SimpleAdapterTest.class);
                startActivity(intent);
            }
        });
        Button alertDialog_btn = (Button) findViewById(R.id.alertdialog_btn);
        alertDialog_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AlertDialogTest.class);
                startActivity(intent);
            }
        });
        Button xmlmenu_btn = (Button) findViewById(R.id.xmlmenu_btn);
        xmlmenu_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, XMLMenu.class);
                startActivity(intent);
            }
        });
        Button actionmode_btn = (Button) findViewById(R.id.actionmode_btn);
        actionmode_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActionModeTest.class);
                startActivity(intent);
            }
        });
    }


}
