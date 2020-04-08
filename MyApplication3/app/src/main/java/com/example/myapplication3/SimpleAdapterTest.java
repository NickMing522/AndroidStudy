package com.example.myapplication3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SimpleAdapterTest extends Activity {
    private String[] animals =new String[] {"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] images =new int[] {R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    ListView simpleAdapterList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simpleadapter);

        simpleAdapterList = (ListView) findViewById(R.id.simpleAdapterList);

        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        for (int i = 0; i < animals.length; i++) {
            Map<String, Object> hashMap = new HashMap<>();
            hashMap.put("name", animals[i]);
            hashMap.put("image", images[i]);
            arrayList.add(hashMap);
        }
        String[] title = {"name", "image"};
        int[] context = {R.id.name, R.id.image};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.listview1, title, context);
        simpleAdapterList.setAdapter(simpleAdapter);

        simpleAdapterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), animals[position], Toast.LENGTH_LONG).show();
            }
        });

    }
}
