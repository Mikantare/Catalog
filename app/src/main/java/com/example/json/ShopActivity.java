package com.example.json;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.json.Adapter.PartsAdapter;
import com.example.json.Data.Part;
import com.example.json.Utils.GetJSONFromNetwork;
import com.example.json.Utils.NetworkUtils;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity {

    private ImageView imageViewLogoModel;
    private TextView textViewModelName;
    private TextView textViewProducedBy;
    private RecyclerView recyclerViewShop;
    private TextView textViewPartNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        imageViewLogoModel = findViewById(R.id.imageViewLogoModel);
        textViewModelName = findViewById(R.id.textViewModelName);
        textViewProducedBy = findViewById(R.id.textViewProducedBy);
        recyclerViewShop = findViewById(R.id.recyclerViewShop);
        textViewPartNumber = findViewById(R.id.textViewPartNumber);
        Intent intent = getIntent();
        final String nameModel = intent.getStringExtra("name");
        final String imageNameURL = intent.getStringExtra("imageURL");
        textViewProducedBy.setText(GetJSONFromNetwork.getClassMan());
        textViewModelName.setText(nameModel);
        imageViewLogoModel.setImageBitmap(NetworkUtils.getImage(imageNameURL));
        PartsAdapter adapter = new PartsAdapter();
        recyclerViewShop.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewShop.setAdapter(adapter);
        ArrayList <Part> parts =GetJSONFromNetwork.getPartsFromJSON(GetJSONFromNetwork.getJSON());
        textViewPartNumber.setText("" + parts.size());
        adapter.setParts(parts);
    }
}
