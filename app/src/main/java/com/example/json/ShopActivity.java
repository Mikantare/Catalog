package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.json.Utils.GetJSONFromNetwork;
import com.example.json.Utils.NetworkUtils;

public class ShopActivity extends AppCompatActivity {

    private ImageView imageViewLogoModel;
    private TextView textViewModelName;
    private TextView textViewProducedBy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        imageViewLogoModel = findViewById(R.id.imageViewLogoModel);
        textViewModelName = findViewById(R.id.textViewModelName);
        textViewProducedBy = findViewById(R.id.textViewProducedBy);
        Intent intent = getIntent();
        final String nameModel = intent.getStringExtra("name");
        final String imageNameURL = intent.getStringExtra("imageURL");
        textViewProducedBy.setText(GetJSONFromNetwork.getClassMan());
        textViewModelName.setText(nameModel);
        imageViewLogoModel.setImageBitmap(NetworkUtils.getImage(imageNameURL));


    }
}
