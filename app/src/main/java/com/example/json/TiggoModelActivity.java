package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.json.Utils.NetworkUtils;

public class TiggoModelActivity extends AppCompatActivity {

    private ImageView imageViewLogoModel;
    private TextView textViewModel;
    private RadioGroup radioGroupConfigurationTiggo;
    private RadioGroup radioGroupConfigurationTiggoFL;
    private RadioGroup radioGroupConfigurationM11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiggo_model);
        imageViewLogoModel = findViewById(R.id.imageViewLogoModel);
        textViewModel = findViewById(R.id.textViewModel);
        radioGroupConfigurationTiggo = findViewById(R.id.radioGroupConfigurationTiggo);
        radioGroupConfigurationTiggoFL = findViewById(R.id.radioGroupConfigurationTiggoFL);
        radioGroupConfigurationM11 = findViewById(R.id.radioGroupConfigurationM11);
        Intent intent = getIntent();
        final String nameModel = intent.getStringExtra("name");
        final String imageNameURL = intent.getStringExtra("imageURL");
        final String nameBrand = intent.getStringExtra("brand");
        if (nameModel.equals("Chery Tiggo")) {
            radioGroupConfigurationTiggo.setVisibility(View.VISIBLE);
            radioGroupConfigurationTiggoFL.setVisibility(View.INVISIBLE);
            radioGroupConfigurationM11.setVisibility(View.INVISIBLE);

        }
        else if (nameModel.equals("Chery M11 M12")){
            radioGroupConfigurationTiggo.setVisibility(View.INVISIBLE);
            radioGroupConfigurationTiggoFL.setVisibility(View.INVISIBLE);
            radioGroupConfigurationM11.setVisibility(View.VISIBLE);
        }
        else {
            radioGroupConfigurationTiggo.setVisibility(View.INVISIBLE);
            radioGroupConfigurationTiggoFL.setVisibility(View.VISIBLE);
            radioGroupConfigurationM11.setVisibility(View.INVISIBLE);
        }
        textViewModel.setText(nameModel);
        imageViewLogoModel.setImageBitmap(NetworkUtils.getImage(imageNameURL));
    }
}
