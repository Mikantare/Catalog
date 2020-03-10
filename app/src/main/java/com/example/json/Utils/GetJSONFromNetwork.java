package com.example.json.Utils;

import android.net.Uri;
import android.telephony.SmsManager;
import android.util.Log;

import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class GetJSONFromNetwork {
    private static final String BASE_URL_SEARCH = "https://www.zzap.ru/webservice/datasharing.asmx/GetSearchResultV3";
    private static final String API_KEY = "MBmE7rdJlQjqwrEpyY78ho2YSeaGsND9tFzzPCrjfBtX5ico5YkBlGkMZDR";

    // Для метода "Результат посика"
    private static final String PARAMS_API_KEY = "api_key";
    private static final String PARAMS_API_LOGIN = "login";
    private static final String PARAMS_API_PASSWORD = "password";
    private static final String PARAMS_API_SEARCH_TEXT = "search_text";
    private static final String PARAMS_API_CODE_REGION = "code_region";
    private static final String PARAMS_API_PARTNUMBER = "partnumber";
    private static final String PARAMS_API_CLASS_MAN = "class_man";
    private static final String PARAMS_API_TYPE_REQUEST = "type_request";
    private static final String PARAMS_API_ROW_COUNT = "row_count";

    private static final String PASSWORD = "4d645c5730";
    private static final String LOGIN = "garajv@yandex.ru";
    private static final String CODE_REGION = "11111";
    private static final String PARTNUMBER = "481h-1012010";
    private static final String CLASS_MAN = "CHERY";
    private static final String ROW_COUNT = "5";
    private static final String TYPE_REQUEST = "";
    private static final String SEARCH_TEXT = "";


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
                .appendQueryParameter(PARAMS_API_TYPE_REQUEST,TYPE_REQUEST)
                .appendQueryParameter(PARAMS_API_KEY, API_KEY).build();
        try {
            searchURL = new URL(uri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Log.i("Result",uri.toString());
        return searchURL;
    }

    public static JSONObject getJSONFromNetwork() {
        return null;
    }

}
