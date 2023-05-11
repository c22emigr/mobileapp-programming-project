package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Bergen> Berg;
    public RecyclerViewAdapter(List<Bergen> Berg) {
        this.Berg = Berg;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(Berg.get(position).getName());
        holder.size.setText(String.valueOf(Berg.get(position).getSize()));
    }

    @Override
    public int getItemCount() {
        return Berg.size();
    }
}
