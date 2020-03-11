package com.example.json.Data;

public class Parts {

    private String partNumber;
    private String classMan;
    private String partName;
    private String quantity;
    private String price;

    public Parts(String partNumber, String classMan, String partName, String quantity, String price) {
        this.partNumber = partNumber;
        this.classMan = classMan;
        this.partName = partName;
        this.quantity = quantity;
        this.price = price;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
