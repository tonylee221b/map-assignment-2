package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ManagerPanel extends AppCompatActivity implements View.OnClickListener {
    Button his_btn, res_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_panel);

        // initialization
        his_btn = findViewById(R.id.history_btn);
        res_btn = findViewById(R.id.restock_btn);

        his_btn.setOnClickListener(this);
        res_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.history_btn:
                Intent hisIntent = new Intent(this, HistoryListActivity.class);
                startActivity(hisIntent);
                break;
            case R.id.restock_btn:
                Intent restockIntent = new Intent(this, RestockPage.class);
                startActivity(restockIntent);
                break;
        }
    }
}
