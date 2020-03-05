package com.example.json.Utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetTextContent {




    public static ArrayList<String> getNameArray(String beginingPatternAll, String endPatternAll, String beginingPattern, String endPattern, String url) {
        ArrayList<String> splitResult = new ArrayList<>();
        String toPattern = NetworkUtils.getBrand(url);
        Pattern patternAll = Pattern.compile(beginingPatternAll + "(.*?)" + endPatternAll);
        Matcher matcherAll = patternAll.matcher(toPattern);
        String splitContent = "";
        while (matcherAll.find()) {
            splitContent = matcherAll.group(1);
        }
        Pattern patternName = Pattern.compile(beginingPattern + "(.*?)" + endPattern);
        Matcher matcherName = patternName.matcher(splitContent);
        while (matcherName.find()) {
            splitResult.add(matcherName.group(1));
            Log.i("MyResult", matcherName.group(1));
        }
//        for (String splitResults: splitResult) {
//            Pattern pattern = Pattern.compile();
//        }

        return null;
    }
}
