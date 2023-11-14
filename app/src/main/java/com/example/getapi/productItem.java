package com.example.getapi;

import java.io.Serializable;

public class productItem implements Serializable {
    private String id;
    private  String title;
    private  double price;
    private int quantity;
    private double total;
    private double discountPercentage;
    private double discountedPrice;
    private String thumbnail;

    public productItem(String id, String title, double price, int quantity, double total, double discountPercentage, double discountedPrice, String thumbnail) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.discountPercentage = discountPercentage;
        this.discountedPrice = discountedPrice;
        this.thumbnail = thumbnail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
