package com.example.assignment2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RestockPage extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    EditText enter;
    Button ok_btn, cancel_btn;
    ListView stockList;

    Product product;
    ProductListManager prodManager;
    ProductListAdapter prodAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restock_layout);

        // Initialization
        enter = findViewById(R.id.enter);
        ok_btn = findViewById(R.id.ok_btn);
        cancel_btn = findViewById(R.id.cancel_btn);
        stockList = findViewById(R.id.stock_list);
        prodManager = ((MyApp)getApplication()).prodListManager;
        product = new Product();

        prodAdapter = new ProductListAdapter(this, prodManager.getAllProductList());
        stockList.setAdapter(prodAdapter);

        // EventHandlers
        stockList.setOnItemClickListener(this);
        ok_btn.setOnClickListener(this);
        cancel_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.ok_btn:
                if (enter.getText().toString().equals(""))
                    Toast.makeText(this, "All fields are REQUIRED", Toast.LENGTH_SHORT).show();
                else {
                    product.setQty(product.getQty() + Integer.parseInt(enter.getText().toString()));
                    prodManager.setProductQty(product);
                    prodAdapter.notifyDataSetChanged();
                    enter.setText("");
                }
                break;
            case R.id.cancel_btn:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
        product = prodAdapter.getItem(pos);
    }
}
