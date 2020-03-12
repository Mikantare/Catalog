package com.example.json.Utils;

import android.net.Uri;
import android.os.AsyncTask;
import android.telephony.SmsManager;
import android.util.Log;

import com.example.json.Data.Part;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetJSONFromNetwork {
    private static final String BASE_URL_SEARCH = "https://www.zzap.ru/webservice/datasharing.asmx/GetSearchResultV3";
    private static final String API_KEY = "MBmE7rdJlQjqwrEpyY78ho2YSeaGsND9tFzzPCrjfBtX5ico5YkBlGkMZDR";
    private static final String PARAMS_API_KEY = "api_key";
    private static final String PARAMS_API_LOGIN = "login";
    private static final String PARAMS_API_PASSWORD = "password";
    private static final String PASSWORD = "4d645c5730";
    private static final String LOGIN = "garajv@yandex.ru";

    // Для метода "Результат посика"

    private static final String PARAMS_API_SEARCH_TEXT = "search_text";
    private static final String PARAMS_API_CODE_REGION = "code_region";
    private static final String PARAMS_API_PARTNUMBER = "partnumber";
    private static final String PARAMS_API_CLASS_MAN = "class_man";
    private static final String PARAMS_API_TYPE_REQUEST = "type_request";
    private static final String PARAMS_API_ROW_COUNT = "row_count";


    private static final String CODE_REGION = "11111";
    private static final String PARTNUMBER = "481h-1012010";
    private static final String CLASS_MAN = "CHERY";
    private static final String ROW_COUNT = "5";
    private static final String TYPE_REQUEST = "";
    private static final String SEARCH_TEXT = "";

    //    информация о детали
    private static final String KEY_RESULT = "table";
    private static final String KEY_PART_NUMBER = "partnumber";
    private static final String KEY_CLASS_MAN = "class_man";
    private static final String KEY_PART_NAME = "class_cat";
    private static final String KEY_DELIVEY_TIME = "delivery_days";
    private static final String KEY_COUNT = "qty";
    private static final String KEY_PRICE = "descr_price_orig";


    public static URL buildURLSearch() {
        URL searchURL = null;
        Uri uri = Uri.parse(BASE_URL_SEARCH).buildUpon()
                .appendQueryParameter(PARAMS_API_LOGIN, LOGIN)
                .appendQueryParameter(PARAMS_API_PASSWORD, PASSWORD)
                .appendQueryParameter(PARAMS_API_SEARCH_TEXT, SEARCH_TEXT)
                .appendQueryParameter(PARAMS_API_PARTNUMBER, PARTNUMBER)
                .appendQueryParameter(PARAMS_API_CLASS_MAN, CLASS_MAN)
                .appendQueryParameter(PARAMS_API_CODE_REGION, CODE_REGION)
                .appendQueryParameter(PARAMS_API_ROW_COUNT, ROW_COUNT)
                .appendQueryParameter(PARAMS_API_TYPE_REQUEST, TYPE_REQUEST)
                .appendQueryParameter(PARAMS_API_KEY, API_KEY).build();
        try {
            searchURL = new URL(uri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return searchURL;
    }
//    Для проверки

    public static String getClassMan() {
        return CLASS_MAN;
    }

    public static ArrayList <Part> getPartsFromJSON (JSONObject jsonObject) {
        ArrayList <Part> result = new ArrayList<>();
        if (jsonObject == null) {
            return result;
        }
        try {
            JSONArray jsonArray = jsonObject.getJSONArray(KEY_RESULT);
            for (int i =0; i < jsonArray.length(); i++) {
                JSONObject objectParts = jsonArray.getJSONObject(i);
                String partNumber = objectParts.getString(KEY_PART_NUMBER);
                String classMan = objectParts.getString(KEY_CLASS_MAN);
                String partName = objectParts.getString(KEY_PART_NAME);
                String deliveryTime = (Integer.toString(objectParts.getInt(KEY_DELIVEY_TIME)));
                String count = objectParts.getString(KEY_COUNT);
                String price = objectParts.getString(KEY_PRICE);
                Part part = new Part(partNumber,classMan,partName,deliveryTime,count,price);
                result.add(part);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static JSONObject getJSON() {
        JSONObject result = null;
        URL url = buildURLSearch();
        try {
            result = new JSONLoadTask().execute(url).get();
            } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static class JSONLoadTask extends AsyncTask<URL, Void, JSONObject> {
        @Override
        protected JSONObject doInBackground(URL... urls) {
            JSONObject searchJSON = null;
            if (urls == null || urls.length == 0) {
                return searchJSON;
            }
            HttpURLConnection httpURLConnection = null;
            try {
                httpURLConnection = (HttpURLConnection) urls[0].openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder stringBuilder = new StringBuilder();
                String line = bufferedReader.readLine();
                while (line != null) {
                    stringBuilder.append(line);
                    line = bufferedReader.readLine();
                }
                String splitResult = null;
                Pattern pattern = Pattern.compile("www.zzap.ru/\">(.*?)</string>");
                Matcher matcher = pattern.matcher(stringBuilder.toString());
                while (matcher.find()) {
                    splitResult =   matcher.group(1);
                }
                Log.i("Result2","" + splitResult);
                searchJSON = new JSONObject(splitResult);
//
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }

            return searchJSON;
        }
    }

}
