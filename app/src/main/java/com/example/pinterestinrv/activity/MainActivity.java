package com.example.pinterestinrv.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;

import com.example.pinterestinrv.R;
import com.example.pinterestinrv.adapter.CustomAdapter;
import com.example.pinterestinrv.helper.SpacesItemDecoration;
import com.example.pinterestinrv.model.ImageItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        ArrayList<ImageItem> imageItems = prepareImageList();
        refreshAdapter(imageItems);

    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        SpacesItemDecoration decoration = new SpacesItemDecoration(10);  // This class create Pinterest Images
        recyclerView.addItemDecoration(decoration);
    }


    private void refreshAdapter(ArrayList<ImageItem> imageItems) {
        CustomAdapter adapter = new CustomAdapter(context, imageItems);
        recyclerView.setAdapter(adapter);
    }


    private ArrayList<ImageItem> prepareImageList() {
        ArrayList<ImageItem> imageItems = new ArrayList<>();
        for (int i = 1; i < 41; i++) {
            if (i % 4 == 1) {
                imageItems.add(new ImageItem(i + ")image", R.drawable.photo1));
            } else if (i % 4 == 3) {
                imageItems.add(new ImageItem(i + ")image", R.drawable.photo3));
            } else if (i % 4 == 2) {
                imageItems.add(new ImageItem(i + ")image", R.drawable.photo2));
            } else {
                imageItems.add(new ImageItem(i + ")image", R.drawable.photo4));
            }
        }
        return imageItems;
    }


}