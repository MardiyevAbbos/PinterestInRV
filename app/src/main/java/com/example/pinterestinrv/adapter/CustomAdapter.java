package com.example.pinterestinrv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pinterestinrv.R;
import com.example.pinterestinrv.model.ImageItem;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<ImageItem> imageItems;

    public CustomAdapter(Context context, ArrayList<ImageItem> imageItems) {
        this.context = context;
        this.imageItems = imageItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_custom_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImageItem imageItem = imageItems.get(position);
        if (holder instanceof CustomViewHolder) {
            TextView name = ((CustomViewHolder) holder).name;
            ImageView imageView = ((CustomViewHolder) holder).image;

            name.setText(imageItem.getName());
            imageView.setImageResource(imageItem.getImage());
        }
    }

    @Override
    public int getItemCount() {
        return imageItems.size();
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView name;
        public ImageView image;

        public CustomViewHolder(View view) {
            super(view);
            this.view = view;
            name = view.findViewById(R.id.tv_imageName);
            image = view.findViewById(R.id.iv_image);
        }
    }


}
