package com.example.assignment2;

import android.app.Application;

public class MyApp extends Application {
    Product mainProduct = new Product();
    ProductListManager prodListManager = new ProductListManager();

    HistoryListManager hisListManager = new HistoryListManager();
}
