package com.happycoderz.espa.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.happycoderz.espa.R;
import com.happycoderz.espa.adapter.GaleryAdapter;
import com.happycoderz.espa.model.Photo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GaleryActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.galery_back_icon)
    ImageView galeryBackIcon;
    ArrayList<Photo> photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galery);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        photos = new ArrayList<Photo>();
        //TODO(1) --  API'ye fotolar eklenince bu fotolar apidekiler ile güncellenecek
        photos.add(new Photo("http://www.sevimaluminyum.com/wp-content/uploads/2017/09/surme-kapi-7-768x660.jpg"));
        photos.add(new Photo("http://www.sevimaluminyum.com/wp-content/uploads/2017/09/izmirpanjur-com-plastik-dograma-2.jpg"));
        photos.add(new Photo("http://www.sevimaluminyum.com/wp-content/uploads/2017/09/7C1319-F07B57-102656-59B107-904023-7DCB91-768x432.jpg"));
        photos.add(new Photo("http://www.kardeslerotomatikkapi.com/img/262/6820.jpg"));
        photos.add(new Photo("http://www.sevimaluminyum.com/wp-content/uploads/2017/09/ats_cam_balkon_6.jpg"));
        photos.add(new Photo("http://www.sevimaluminyum.com/wp-content/uploads/2017/09/surme-kapi-7-768x660.jpg"));
        photos.add(new Photo("http://www.sevimaluminyum.com/wp-content/uploads/2017/09/izmirpanjur-com-plastik-dograma-2.jpg"));
        photos.add(new Photo("http://www.sevimaluminyum.com/wp-content/uploads/2017/09/7C1319-F07B57-102656-59B107-904023-7DCB91-768x432.jpg"));
        photos.add(new Photo("http://www.kardeslerotomatikkapi.com/img/262/6820.jpg"));

        recyclerView.setAdapter(new GaleryAdapter(photos, R.layout.galery_recycler_view_item, getApplicationContext()));
    }

    @OnClick(R.id.galery_back_icon)
    void onbackClicked(){
        finish();
    }
}
