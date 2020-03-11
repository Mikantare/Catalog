package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.json.Utils.NetworkUtils;

public class ModelActivity extends AppCompatActivity {

    private ImageView imageViewLogoModel;
    private TextView textViewModel;
    private ListView listViewConsumables;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);
        listViewConsumables = findViewById(R.id.listViewConsumables);
        imageViewLogoModel = findViewById(R.id.imageViewLogoModel);
        textViewModel = findViewById(R.id.textViewModel);
        Intent intent = getIntent();
        final String nameModel = intent.getStringExtra("name");
        final String imageNameURL = intent.getStringExtra("imageURL");
        textViewModel.setText(nameModel);
        imageViewLogoModel.setImageBitmap(NetworkUtils.getImage(imageNameURL));
        listViewConsumables.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentToParts = new Intent(getApplicationContext(),ShopActivity.class);
                intentToParts.putExtra("name",nameModel);
                intentToParts.putExtra("imageURL",imageNameURL);
                startActivity(intentToParts);
            }
        });
    }
}
