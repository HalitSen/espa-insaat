package com.happycoderz.espa.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView;
import com.happycoderz.espa.R;
import com.happycoderz.espa.adapter.ProductAdapter;
import com.happycoderz.espa.helper.CacheHelper;
import com.happycoderz.espa.model.EspaResponse;
import com.happycoderz.espa.model.Product;
import com.happycoderz.espa.model.SubCategory;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class ProductActivity extends AppCompatActivity {

    ArrayList<Product> products;
    EspaResponse espaResponse;
    ProductAdapter productAdapter;
    Product product;
    SubCategory subCategory;

    @BindView(R.id.product_list_view)
    ExpandableHeightListView productListView;
    @BindView(R.id.product_label_text)
    TextView productLabelText;
    @BindView(R.id.product_back_icon)
    ImageView productBackIcon;
    int categoryPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ButterKnife.bind(this);
        products = new ArrayList<Product>();
        product = new Product();
        espaResponse = new EspaResponse();
        subCategory = new SubCategory();

        Intent intent = getIntent();
        getIntentExtra(intent);
        }

    @OnClick(R.id.product_back_icon)
    void onProductBackIconClicked(){
        finish();
    }

    @OnItemClick(R.id.product_list_view)
    void onProductListClicked(AdapterView<?> parent, int position){

        product =products.get(position);
        Intent intentDetail = new Intent(this,ProductDetailActivity.class);
        intentDetail.putExtra("productDetail",product);
        startActivity(intentDetail);
    }

    private void getIntentExtra(Intent intent){
        if(intent.hasExtra("productPosition")){
            categoryPosition = intent.getIntExtra("productPosition", -1);
            espaResponse = (CacheHelper.getInstance(this).getObject("espaInfo", EspaResponse.class));
            products = espaResponse.categories.get(categoryPosition).getProducts();
            productAdapter = new ProductAdapter(this, products);
            productListView.setAdapter(productAdapter);
            productLabelText.setText(espaResponse.categories.get(categoryPosition).getTitle());
        }
        else {
            subCategory = (SubCategory) intent.getSerializableExtra("subCat");
            int position = intent.getIntExtra("position",-1);
            Log.v("subCatPro : ",subCategory.getTitle());
            products = subCategory.getProduct();
            productAdapter = new ProductAdapter(this, products);
            productListView.setAdapter(productAdapter);
            productLabelText.setText(products.get(position).getTitle());
        }
    }
}