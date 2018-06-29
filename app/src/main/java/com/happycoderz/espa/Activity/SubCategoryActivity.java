package com.happycoderz.espa.Activity;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView;
import com.happycoderz.espa.R;
import com.happycoderz.espa.adapter.SubCategoryAdapter;
import com.happycoderz.espa.helper.CacheHelper;
import com.happycoderz.espa.model.EspaResponse;
import com.happycoderz.espa.model.SubCategory;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SubCategoryActivity extends AppCompatActivity {

    @BindView(R.id.sub_cat_title)
    TextView subCatTitle;
    @BindView(R.id.sub_cat_list_view)
    ExpandableHeightListView subCatListView;
    @BindView(R.id.sub_cat_back_icon)
    ImageView subCategoryBackIcon;

    SubCategoryAdapter subCategoryAdapter;
    ArrayList<SubCategory> subCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);
        ButterKnife.bind(this);

        int position = -1;

        position = getIntent().getIntExtra("subCategoryPosition", -1);
        EspaResponse r = (CacheHelper.getInstance(this).getObject("espaInfo", EspaResponse.class));
        subCategories = new ArrayList<SubCategory>();
        subCategories = r.categories.get(position).getSubCategories();
        // position 6 dır

        Log.v("hasSubTitle",r.categories.get(position).getTitle());
        Log.v("firsSubCategory : ", subCategories.get(0).getTitle());

        subCategoryAdapter = new SubCategoryAdapter(this,subCategories);
        subCatListView.setAdapter(subCategoryAdapter);
        subCatTitle.setText(r.categories.get(position).getTitle());
        subCatListView.setExpanded(true);
        subCatListView.setFocusable(false);
    }
    @OnClick(R.id.sub_cat_back_icon)
    void onSubCatBackClicked(){
        finish();
    }
}
