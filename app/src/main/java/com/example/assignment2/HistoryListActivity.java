package com.example.assignment2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryListActivity extends AppCompatActivity {
    RecyclerView historyView;
    HistoryListAdapter historyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_list_layout);

        // Initialization
        historyView = findViewById(R.id.history_list_view);
        historyAdapter = new HistoryListAdapter(((MyApp)getApplication()).hisListManager.getAllHistory());

        // RecyclerView
        historyView.setAdapter(historyAdapter);
        historyView.setLayoutManager(new LinearLayoutManager(this));
    }
}
