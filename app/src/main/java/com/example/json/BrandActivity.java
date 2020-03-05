package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.json.Utils.GetTextContent;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BrandActivity extends AppCompatActivity {

    private TextView textViewBrand;
    private ListView listViewBrand;
    private ImageView imageViewLogoBrand;

    private ArrayList<String> name = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);
        textViewBrand = findViewById(R.id.textViewBrand);
        listViewBrand = findViewById(R.id.listViewBrand);
        imageViewLogoBrand = findViewById(R.id.imageViewLogoBrand);
        Intent intent = getIntent();
        String urlBrand = intent.getStringExtra("referenceBrand");
        String nameBrand = intent.getStringExtra("brend");
        textViewBrand.setText(nameBrand);
        name = GetTextContent.GetNameBrandArray(urlBrand);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,name);
        listViewBrand.setAdapter(adapter);
        Bitmap bitmap = GetTextContent.GetImageBrand(urlBrand);
        if (bitmap != null) {
            imageViewLogoBrand.setImageBitmap(GetTextContent.GetImageBrand(urlBrand));
        }

    }
}
