package com.happycoderz.espa.Activity;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.happycoderz.espa.R;
import com.happycoderz.espa.model.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class ProductDetailActivity extends AppCompatActivity {

    Product product;

    @BindView(R.id.product_detail_image)
    ImageView productDetailImage;
    @BindView(R.id.product_detail_description_text)
    TextView productDescription;
    @BindView(R.id.product_detail_label_text)
    TextView productNameTitle;
    @BindView(R.id.product_detail_back_icon)
    ImageView productDetailBackIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);
        product = new Product();
        product = (Product) getIntent().getSerializableExtra("productDetail");

        //TODO(2) -- api ye ürün açıklamas eklenince modelde description düncellenecek
        productDescription.setText(product.getDescription());
        productNameTitle.setText(product.getTitle());
        Picasso.with(this)
                .load(product.getImage())
                .into(productDetailImage);
    }
    @OnClick(R.id.product_detail_back_icon)
    void onBackIconClicked(){
        finish();
    }
}

