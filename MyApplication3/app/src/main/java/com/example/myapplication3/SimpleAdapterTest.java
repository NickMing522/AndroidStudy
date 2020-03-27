package com.example.myapplication3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterTest extends Activity {
    String[] animal = {"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    int[] image = {R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    ListView simpleAdapterList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simpleadapter);

        simpleAdapterList = (ListView) findViewById(R.id.simpleAdapterList);

        ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
        for(int i=0;i<animal.length;i++){
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("name",animal[i]);
            hashMap.put("image",image[i]+"");
            arrayList.add(hashMap);
        }
        String[] title = {"name","image"};
        int[] context = {R.id.name,R.id.image};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,arrayList,R.layout.listview1,title,context);
        simpleAdapterList.setAdapter(simpleAdapter);

    }
}
