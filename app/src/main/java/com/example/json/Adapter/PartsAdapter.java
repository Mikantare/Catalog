package com.example.json.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.json.Data.Part;
import com.example.json.R;

import java.util.ArrayList;

public class PartsAdapter extends RecyclerView.Adapter<PartsAdapter.PartsViewHolder> {

    ArrayList <Part> parts;


    @NonNull
    @Override
    public PartsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parts_item,parent,false);
        return new PartsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PartsViewHolder holder, int position) {
            Part part = parts.get(position);
            holder.textViewName.setText(part.getPartName());
            holder.textViewCount.setText(part.getCount());
            holder.textViewDeliveryTime.setText(part.getDeliveryTime());
            holder.textViewPrice.setText(part.getPrice());
    }

    @Override
    public int getItemCount() {
        return parts.size();
    }

    class PartsViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName;
        private TextView textViewCount;
        private TextView textViewDeliveryTime;
        private TextView textViewPrice;

        public PartsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewCount = itemView.findViewById(R.id.textViewCount);
            textViewDeliveryTime = itemView.findViewById(R.id.textViewDeliveryTime);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);

        }



    }
}
