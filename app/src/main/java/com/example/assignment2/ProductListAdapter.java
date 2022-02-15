package com.example.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductListAdapter extends BaseAdapter {
    ArrayList<Product> prodList;
    Context context;

    public ProductListAdapter(Context context, ArrayList<Product> p) {
        this.context = context;
        this.prodList = p;
    }

    @Override
    public int getCount() { return prodList.size(); }

    @Override
    public long getItemId(int pos) { return pos; }

    @Override
    public Product getItem(int pos) { return prodList.get(pos); }

    @Override
    public View getView(int pos, View view, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.product_list, null);

        TextView itemName = v.findViewById(R.id.prod_item_name);
        TextView itemQty = v.findViewById(R.id.prod_item_qty);
        TextView itemPrice = v.findViewById(R.id.prod_item_price);

        itemName.setText(prodList.get(pos).getName());
        itemQty.setText(String.valueOf(prodList.get(pos).getQty()));
        itemPrice.setText(String.valueOf(prodList.get(pos).getPrice()));

        return v;
    }
}
