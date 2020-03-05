package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.lang.UCharacter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.json.Utils.GetTextContent;
import com.example.json.Utils.NetworkUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private  String chinaMobileURL = "https://xn--80actcpdfk0f.xn--p1ai/";
    private String beginingPatternAll = "<li class";
    private String endPatternAll = " </li></ul>";
    private String beginingPattern = "\">";
    private String endPattern = "a>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetTextContent.getNameArray(beginingPatternAll,endPatternAll,beginingPattern,endPattern,chinaMobileURL);

    }




}