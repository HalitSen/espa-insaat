package com.happycoderz.espa.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView;
import com.happycoderz.espa.R;
import com.happycoderz.espa.adapter.ProductAdapter;
import com.happycoderz.espa.helper.CacheHelper;
import com.happycoderz.espa.model.EspaResponse;
import com.happycoderz.espa.model.Product;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductActivity extends AppCompatActivity {

    ArrayList<Product> products;
    EspaResponse espaResponse;
    ProductAdapter productAdapter;

    @BindView(R.id.product_list_view)
    ExpandableHeightListView productListView;
    @BindView(R.id.product_label_text)
    TextView productLabelText;
    @BindView(R.id.product_back_icon)
    ImageView productBackIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ButterKnife.bind(this);
        products = new ArrayList<Product>();
        espaResponse = new EspaResponse();

        int position = -1;

        position = getIntent().getIntExtra("productPosition", -1);
        espaResponse = (CacheHelper.getInstance(this).getObject("espaInfo", EspaResponse.class));
        products = espaResponse.categories.get(position).getProducts();

        productAdapter = new ProductAdapter(this, products);
        productListView.setAdapter(productAdapter);
        productLabelText.setText(espaResponse.categories.get(position).getTitle());

        Log.v("product1 : ", products.get(0).getTitle());
    }

    @OnClick(R.id.product_back_icon)
    void onProductBackIconClicked(){
        finish();
    }
}
