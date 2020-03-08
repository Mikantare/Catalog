package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.json.Utils.NetworkUtils;

public class ModelActivity extends AppCompatActivity {

    private ImageView imageViewLogoModel;
    private TextView textViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);
        imageViewLogoModel = findViewById(R.id.imageViewLogoModel);
        textViewModel = findViewById(R.id.textViewModel);
        Intent intent = getIntent();
        String nameModel = intent.getStringExtra("name");
        String imageNameURL = intent.getStringExtra("imageURL");
        textViewModel.setText(nameModel);
        imageViewLogoModel.setImageBitmap(NetworkUtils.getImage(imageNameURL));
    }
}
