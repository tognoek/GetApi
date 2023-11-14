package com.example.getapi;

import java.util.ArrayList;

public class products {
    private String id;
    private ArrayList<productItem> productItemArrayList;
    private double total;
    private double discountedTotal;
    private String userId;
    private int totalProducts;
    private int totalQuantity;

    public products(String id, ArrayList<productItem> productItemArrayList, double total, double discountedTotal, String userId, int totalProducts, int totalQuantity) {
        this.id = id;
        this.productItemArrayList = productItemArrayList;
        this.total = total;
        this.discountedTotal = discountedTotal;
        this.userId = userId;
        this.totalProducts = totalProducts;
        this.totalQuantity = totalQuantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<productItem> getProductItemArrayList() {
        return productItemArrayList;
    }

    public void setProductItemArrayList(ArrayList<productItem> productItemArrayList) {
        this.productItemArrayList = productItemArrayList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDiscountedTotal() {
        return discountedTotal;
    }

    public void setDiscountedTotal(double discountedTotal) {
        this.discountedTotal = discountedTotal;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(int totalProducts) {
        this.totalProducts = totalProducts;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
