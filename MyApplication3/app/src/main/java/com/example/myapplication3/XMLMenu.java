package com.example.myapplication3;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AppComponentFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;

public class XMLMenu extends AppCompatActivity {
    private void makeActionOverflowMenuShown() {
        //devices with hardware menu button (e.g. Samsung Note) don't show action overflow menu
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception e) {

        }
    }
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeActionOverflowMenuShown();
        setContentView(R.layout.xmlmenu);
        textView = (TextView) findViewById(R.id.testview);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.mian_menu,menu);
        return true;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.big:
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                break;
            case R.id.middle:
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                break;
            case R.id.small:
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,10);
                break;
            case R.id.toast:
                Toast.makeText(XMLMenu.this, "this is toast", Toast.LENGTH_SHORT).show();
                break;
            case R.id.red:
                textView.setTextColor(Color.RED);
                break;
            case R.id.black:
                textView.setTextColor(Color.BLACK);
                break;

        }
        return true;
    }
}
