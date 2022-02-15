package com.example.assignment2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.ViewHolder> {
    ArrayList<History> historyArrayList;

    public HistoryListAdapter(ArrayList<History> h) { this.historyArrayList = h; }

    @NonNull
    @Override
    public HistoryListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryListAdapter.ViewHolder holder, int position) {
        int pos = position;
        holder.onBind(historyArrayList.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(v.getContext(), HistoryDetailPage.class);
                detail.putExtra("History", historyArrayList.get(pos));
                v.getContext().startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return historyArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, qty, total;

        public ViewHolder(@NonNull View v) {
            super(v);

            name = v.findViewById(R.id.his_item_name);
            qty = v.findViewById(R.id.his_item_qty);
            total = v.findViewById(R.id.his_item_total);
        }

        void onBind(History h) {
            name.setText(h.getName());
            qty.setText(String.valueOf(h.getQty()));
            total.setText(String.valueOf(h.getTotal()));
        }
    }
}
