package com.happycoderz.espa.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView;
import com.happycoderz.espa.R;
import com.happycoderz.espa.adapter.RelatedProductsAdapter;
import com.happycoderz.espa.model.Product;
import com.squareup.picasso.Picasso;

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
    @BindView(R.id.product_group_layout)
    LinearLayout relatedProductsLayout;
    @BindView(R.id.related_list_view)
    ExpandableHeightListView relatedListView;

    RelatedProductsAdapter adapter;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);
        product = (Product) getIntent().getSerializableExtra("productDetail");

        try {
            productDescription.setText(Html.fromHtml(product.getDescription()));
        }catch (Exception e) {
            e.printStackTrace();
        }

        productNameTitle.setText(product.getTitle());
        Picasso.with(this)
                .load(product.getImage())
                .into(productDetailImage);

        if (product.getRelatedProducts() == null || product.getRelatedProducts().isEmpty()) {
            relatedProductsLayout.setVisibility(View.GONE);
        } else {
            adapter = new RelatedProductsAdapter(this, product.getRelatedProducts());
            relatedListView.setAdapter(adapter);
            relatedListView.setExpanded(true);
        }

        relatedListView.setFocusable(false);


    }

    @OnItemClick (R.id.related_list_view)
    public void onItemClicked (int pos) {
        Product p = product.getRelatedProducts().get(pos);
        p.setRelatedProducts(product.getRelatedProducts());

        Intent intentDetail = new Intent(this,ProductDetailActivity.class);
        intentDetail.putExtra("productDetail",p);
        startActivity(intentDetail);    }

    @OnClick(R.id.product_detail_back_icon)
    void onBackIconClicked() {
        finish();
    }
}

