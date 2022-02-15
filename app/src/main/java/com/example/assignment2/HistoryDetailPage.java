package com.example.assignment2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HistoryDetailPage extends AppCompatActivity {
    TextView d_name, d_price, d_date;
    History history;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_detail_page);

        // Initialization
        d_name = findViewById(R.id.his_detail_name);
        d_price = findViewById(R.id.his_detail_price);
        d_date = findViewById(R.id.his_detail_date);

        history = getIntent().getParcelableExtra("History");

        d_name.setText("Product: "+ history.getName());
        d_price.setText("Price: " + String.valueOf(history.getTotal()));
        d_date.setText("Purchase Date: " + String.valueOf(history.getDate()));
    }
}
