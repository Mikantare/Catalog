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
        final Intent intent = getIntent();
        final String nameModel = intent.getStringExtra("name");
        final String imageNameURL = intent.getStringExtra("imageURL");
        final String nameBrand = intent.getStringExtra("brand");
        textViewModel.setText(nameModel);
        imageViewLogoModel.setImageBitmap(NetworkUtils.getImage(imageNameURL));
        listViewConsumables.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentToParts = new Intent(getApplicationContext(),ShopActivity.class);
                intentToParts.putExtra("name",nameModel);
                intentToParts.putExtra("imageURL",imageNameURL);
                intentToParts.putExtra("brand",nameBrand);
                switch (position) {
                    case 0:
                        intentToParts.putExtra("partNumber","481h-1012010");
                        break;
                    case 1:
                        intentToParts.putExtra("partNumber","T15-1109111");
                        break;
                    case 2:
                        intentToParts.putExtra("partNumber","T15-8107011");
                        break;
                    case 3:
                        intentToParts.putExtra("partNumber","T11-1117110");
                        break;
                    case 4:
                        intentToParts.putExtra("partNumber","481F-3707010");
                        break;
                    case 5:
                        intentToParts.putExtra("partNumber","T15-6GN3501080");
                        break;
                    case 6:
                        intentToParts.putExtra("partNumber","T15-6GN3502080");
                        break;
                    case 7:
                        intentToParts.putExtra("partNumber","575832");
                        intentToParts.putExtra("brand","VALEO");
                        break;
                    case 8:
                        intentToParts.putExtra("partNumber","T15-5205153");

                        break;
                }



                startActivity(intentToParts);
            }
        });
    }
}
