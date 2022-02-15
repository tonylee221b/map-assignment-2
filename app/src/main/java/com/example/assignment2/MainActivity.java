package com.example.assignment2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, NumberPicker.OnValueChangeListener, View.OnClickListener {
    TextView prod_type, prod_qty, prod_total;
    NumberPicker numPick;
    Button manager_btn, buy_btn;
    ListView prod_list_view;

    AlertDialog.Builder purchaseBuilder;

    Product product;
    ProductListManager productListManager;
    ProductListAdapter prodAdapter;

    History history;
    HistoryListManager historyListManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialization
        prod_type = findViewById(R.id.prod_type);
        prod_qty = findViewById(R.id.qty);
        prod_total = findViewById(R.id.total);
        numPick = findViewById(R.id.num_picker);
        prod_list_view = findViewById(R.id.prod_list);
        manager_btn = findViewById(R.id.manager_btn);
        buy_btn = findViewById(R.id.buy_btn);

        purchaseBuilder = new AlertDialog.Builder(this);

        product = ((MyApp)getApplication()).mainProduct;
        productListManager = ((MyApp)getApplication()).prodListManager;

        history = new History();
        historyListManager = ((MyApp)getApplication()).hisListManager;

        // ListView
        prodAdapter = new ProductListAdapter(this, productListManager.getAllProductList());
        prod_list_view.setAdapter(prodAdapter);

        // EventListeners
        prod_list_view.setOnItemClickListener(this);
        numPick.setOnValueChangedListener(this);
        manager_btn.setOnClickListener(this);
        buy_btn.setOnClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView adapterView, View v, int pos, long id) {
        product = prodAdapter.getItem(pos);

        prod_type.setText(product.getName());
        prod_qty.setText("0");
        prod_total.setText("0");
        numPick.setValue(0);

        switch (prodAdapter.getItem(pos).getName()) {
            case "Pants":
                numPick.setMaxValue(10);
                break;
            case "Shoes":
                numPick.setMaxValue(100);
                break;
            case "Hats":
                numPick.setMaxValue(30);
                break;
            default:
                break;
        }
    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
        if (newVal > product.getQty()) Toast.makeText(this.getApplicationContext(), "No enough quantity in the stock!!!", Toast.LENGTH_SHORT).show();
        else {
            prod_qty.setText(String.valueOf(newVal));
            prod_total.setText(String.valueOf(product.getPrice() * (float)newVal));
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.buy_btn:
                if (prod_type.getText().toString().isEmpty() || prod_qty.getText().toString() == "0")
                    Toast.makeText(this.getApplicationContext(), "All fields are required!!", Toast.LENGTH_SHORT).show();
                else if (numPick.getValue() > product.getQty());
                else {
                    product.setName(prod_type.getText().toString());
                    product.setQty(product.getQty() - Integer.parseInt(prod_qty.getText().toString()));
                    productListManager.setProductQty(product);
                    ((MyApp)getApplication()).mainProduct = new Product();
                    prodAdapter.notifyDataSetChanged();

                    history.setName(prod_type.getText().toString());
                    history.setQty(Integer.parseInt(prod_qty.getText().toString()));
                    history.setTotal(Float.parseFloat(prod_total.getText().toString()));
                    history.setDate(new Date());
                    historyListManager.addHistory(history);
                    history = new History();

                    purchaseBuilder.setTitle("Thank You for your purchase");
                    purchaseBuilder.setMessage("Your purchase is " + prod_qty.getText().toString() + " " + prod_type.getText().toString() + " for " + prod_total.getText().toString());
                    purchaseBuilder.show();
                }
                break;
            case R.id.manager_btn:
                Intent managerIntent = new Intent(this, ManagerPanel.class);
                startActivity(managerIntent);
                break;
            default:
                break;
        }
    }
}