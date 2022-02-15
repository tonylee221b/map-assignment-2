package com.example.assignment2;

public class Product {
    private String p_name;
    private int p_qty;
    private float p_price;

    public Product() {}
    public Product(String name, int qty, float price) {
        this.p_name = name;
        this.p_qty = qty;
        this.p_price = price;
    }

    // Getters and Setters
    public void setName(String name) { this.p_name = name; }
    public void setQty(int qty) { this.p_qty = qty; }

    public String getName() { return this.p_name; }
    public int getQty() { return this.p_qty; }
    public float getPrice() { return this.p_price; }
}
