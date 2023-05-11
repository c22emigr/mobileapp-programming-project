package com.example.project;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView size;
    public TextView name;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        size = itemView.findViewById(R.id.size);
        name = itemView.findViewById(R.id.name);
    }
}
