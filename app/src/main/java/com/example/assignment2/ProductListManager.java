package com.example.assignment2;

import java.util.ArrayList;

public class ProductListManager {
    ArrayList<Product> prodList = new ArrayList<>(0);

    public ProductListManager() {
        Product pants = new Product("Pants", 10, 20.44f);
        Product shoes = new Product("Shoes", 100, 10.44f);
        Product hats = new Product("Hats", 30, 5.9f);

        prodList.add(pants);
        prodList.add(shoes);
        prodList.add(hats);
    }

    public void setProductQty(Product p) {
        String name = p.getName();

        switch (name) {
            case "Pants":
                prodList.get(0).setQty(p.getQty());
                break;
            case "Shoes":
                prodList.get(1).setQty(p.getQty());
                break;
            case "hats":
                prodList.get(2).setQty(p.getQty());
                break;
            default:
                break;
        }
    }

    public ArrayList<Product> getAllProductList() { return this.prodList; }
}
