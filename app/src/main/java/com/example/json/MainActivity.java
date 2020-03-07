package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.json.Utils.GetTextContent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> nameBrand = new ArrayList<>();
    private ArrayList<String> referenceBrand = new ArrayList<>();
    private ListView listViewChinaCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewChinaCar = findViewById(R.id.listViewBrand);
        nameBrand = GetTextContent.GetNameArray();
        referenceBrand = GetTextContent.getReferenceBrand();
        ArrayAdapter<String> adapter= new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1, nameBrand);
        listViewChinaCar.setAdapter(adapter);
        listViewChinaCar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),BrandActivity.class);
                intent.putExtra("brend", nameBrand.get(position));
                intent.putExtra("referenceBrand",referenceBrand.get(position));
                startActivity(intent);
            }
        });
    }




}