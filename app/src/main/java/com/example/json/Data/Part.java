package com.example.json.Data;

public class Part {

    private String partNumber;
    private String classMan;
    private String partName;
    private int deliveryTime;
    private String count;
    private String price;

    public Part(String partNumber, String classMan, String partName, int deliveryTime, String quantity, String price) {
        this.partNumber = partNumber;
        this.classMan = classMan;
        this.partName = partName;
        this.deliveryTime = deliveryTime;
        this.count = quantity;
        this.price = price;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getClassMan() {
        return classMan;
    }

    public void setClassMan(String classMan) {
        this.classMan = classMan;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
