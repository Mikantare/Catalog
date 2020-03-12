package com.example.json.Utils;

import android.graphics.Bitmap;
import android.util.Log;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetTextContent {

    private static ArrayList<String> name = new ArrayList<>();
    private static ArrayList<String> referenceBrand = new ArrayList<>();

    public static ArrayList<String> getReferenceModelImage() {
        return referenceModelImage;
    }

    private static ArrayList<String> referenceModelImage = new ArrayList<>();


    public static ArrayList<String> getReferenceBrand() {
        return referenceBrand;
    }

    public static ArrayList<String> GetSplitName(String beginingPatternAll, String endPatternAll, String beginingPattern, String endPattern, String url) {
        ArrayList<String> splitResult = new ArrayList<>();
        ArrayList<String> splitContent = new ArrayList<>();
        String toPattern = NetworkUtils.getBrand(url);
        Pattern patternAll = Pattern.compile(beginingPatternAll + "(.*?)" + endPatternAll);
        Matcher matcherAll = patternAll.matcher(toPattern);
        while (matcherAll.find()) {
            splitContent.add(matcherAll.group(1));
        }
        for (String splitContects : splitContent) {
            Pattern patternName = Pattern.compile(beginingPattern + "(.*?)" + endPattern);
            Matcher matcherName = patternName.matcher(splitContects);
            while (matcherName.find()) {
                splitResult.add(matcherName.group(1));
            }
        }
        ReferenceBrand(splitResult);
        return splitResult;
    }

    public static ArrayList<String> GetNameArray() {
        name.clear();
        String chinaMobileURL = "https://xn--80actcpdfk0f.xn--p1ai/";
        String beginingPatternAll = "<li class";
        String endPatternAll = " </li></ul>";
        String beginingPattern = "\">";
        String endPattern = "a>";

        ArrayList<String> splitNames = GetSplitName(beginingPatternAll, endPatternAll, beginingPattern, endPattern, chinaMobileURL);
        for (String splitName : splitNames) {
            Pattern pattern = Pattern.compile("\">(.*?)</");
            Matcher matcher = pattern.matcher(splitName);
            while (matcher.find()) {
                name.add(matcher.group(1));
            }
        }
        return name;
    }

    private static ArrayList<String> ReferenceBrand(ArrayList<String> arrayList) {
        ArrayList<String> splitContents = arrayList;
        for (String splitContent : splitContents) {
            Pattern pattern = Pattern.compile("\"/(.*?)\">");
            Matcher matcher = pattern.matcher(splitContent);
            while (matcher.find()) {
                referenceBrand.add("https://xn--80actcpdfk0f.xn--p1ai/" + matcher.group(1));
            }
        }
        return null;
    }

    public static ArrayList<String> GetNameBrandArray(String url) {
        ArrayList<String> model = new ArrayList<>();
        String beginingPatternAll = "end DUMP<br>";
        String endPatternAll = "</div>";
        String beginingPattern = "<a href=";
        String endPattern = "</a>";

        ArrayList<String> splitNames = GetSplitName(beginingPatternAll, endPatternAll, beginingPattern, endPattern, url);
        for (String splitName : splitNames) {
            Pattern pattern = Pattern.compile("alt=\"(.*?)\">");
            Matcher matcher = pattern.matcher(splitName);
            while (matcher.find()) {
                model.add(matcher.group(1));
            }
        }
        getImageModelURL(splitNames);
        return model;
    }

    public static Void getImageModelURL (ArrayList<String> splitnames) {
        referenceModelImage.clear();
        for (String splitName: splitnames) {
            Pattern patternImageModel = Pattern.compile("=\"/(.*?)\" ");
            Matcher matcherImageModel = patternImageModel.matcher(splitName);
            while (matcherImageModel.find()) {
                referenceModelImage.add("https://xn--80actcpdfk0f.xn--p1ai/" + matcherImageModel.group(1));
            }
        }
        return null;
    }


    public static Bitmap GetImageBrand(String url) {
        ArrayList<String> model = new ArrayList<>();
        Bitmap bitmap = null;
        String beginingPatternAll = "<td><img alt";
        String endPatternAll = "width";
        String beginingPattern = "src=\"";
        String endPattern = "\" ";

        ArrayList<String> splitNames = GetSplitName(beginingPatternAll, endPatternAll, beginingPattern, endPattern, url);
        for (String splitName : splitNames) {
            String imageURL = "https://xn--80actcpdfk0f.xn--p1ai" + splitName;
            bitmap = NetworkUtils.getImage(imageURL);
        }
        return bitmap;
    }

}