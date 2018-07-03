package com.happycoderz.espa.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.happycoderz.espa.R;
import com.happycoderz.espa.model.News;
import com.happycoderz.espa.model.Product;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewsDetailActivity extends AppCompatActivity {

    News news;

    @BindView(R.id.product_detail_image)
    ImageView productDetailImage;
    @BindView(R.id.product_detail_description_text)
    TextView productDescription;
    @BindView(R.id.product_detail_back_icon)
    ImageView productDetailBackIcon;
    @BindView(R.id.product_detail_toolbar_title)
    TextView productDetailToolbarTitle;
    @BindView(R.id.product_detail_toolbar)
    Toolbar productDetailToolbar;
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.news_title)
    TextView newsTitle;
    @BindView(R.id.product_detail_layout)
    LinearLayout productDetailLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        ButterKnife.bind(this);

        news = (News) getIntent().getSerializableExtra("news");

        productDescription.setText(Html.fromHtml(news.getContent().getTr()));
        newsTitle.setText(news.getTitle());
        Picasso.with(this)
                .load(news.getImage())
                .into(productDetailImage);
    }

    @OnClick(R.id.product_detail_back_icon)
    void onBackIconClicked() {
        finish();
    }
}

