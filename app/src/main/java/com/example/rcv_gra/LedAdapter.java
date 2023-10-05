package com.example.rcv_gra;

// File: MyAdapter.java
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.recyclerview.widget.RecyclerView;

public class LedAdapter extends RecyclerView.Adapter<LedAdapter.MyViewHolder> {
    private int numItems;

    public LedAdapter(int numItems) {
        this.numItems = numItems;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_turn_on_of, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                holder.imageView.setImageResource(R.drawable.led_on);
            } else {
                holder.imageView.setImageResource(R.drawable.led_off);
            }
        });
    }

    @Override
    public int getItemCount() {
        return numItems;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public Switch switch1;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_led);
            switch1 = itemView.findViewById(R.id.sw_led);
        }
    }
}

