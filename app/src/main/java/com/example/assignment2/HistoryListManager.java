package com.example.assignment2;

import java.util.ArrayList;

public class HistoryListManager {
    ArrayList<History> historyList = new ArrayList<>(0);

    public HistoryListManager () {}

    // Getter and Setter
    public void addHistory(History h) {
        historyList.add(h);
    }
    public ArrayList<History> getAllHistory() { return this.historyList; }
}
