package com.happycoderz.espa.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView;
import com.happycoderz.espa.R;
import com.happycoderz.espa.adapter.ExpandableListViewAdapter;
import com.happycoderz.espa.adapter.NewsAdapter;
import com.happycoderz.espa.helper.CacheHelper;
import com.happycoderz.espa.model.Category;
import com.happycoderz.espa.model.EspaResponse;
import com.happycoderz.espa.model.News;
import com.happycoderz.espa.model.Product;
import com.happycoderz.espa.model.SubCategory;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, NewsAdapter.NewsClickListener {

    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;
    CacheHelper cacheHelper;
    EspaResponse espaResponse;

    @BindView(R.id.container)
    ViewPager mViewPager;
    @BindView(R.id.indicator)
    CircleIndicator circleIndicator;

    NewsAdapter newsAdapter;
    ExpandableListViewAdapter expandableListViewAdapter;

    ArrayList<Category> categories;
    ArrayList<Product> products;
    ArrayList<SubCategory> subCategories;


    @BindView(R.id.expandable_list_view)
    ExpandableHeightListView expandablListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        cacheHelper = new CacheHelper(this);
        espaResponse = new EspaResponse();

        espaResponse = cacheHelper.getObject("espaInfo", EspaResponse.class);

        Log.v("espa from Cache", espaResponse.categories.get(0).getTitle());

        newsAdapter = new NewsAdapter(this);
        mViewPager.setAdapter(newsAdapter);
        circleIndicator.setViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(this);
        categories = new ArrayList<Category>();
        products = new ArrayList<Product>();
        subCategories = new ArrayList<SubCategory>();
        categories = espaResponse.categories;

        expandableListViewAdapter = new ExpandableListViewAdapter(this, categories);
        expandablListView.setAdapter(expandableListViewAdapter);
        expandablListView.setExpanded(true);
        expandablListView.setFocusable(false);
        newsAdapter.setListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.about_us:
                startActivity(new Intent(MainActivity.this, AboutUsActivity.class));
                break;
            case R.id.galery:
                startActivity(new Intent(MainActivity.this, GaleryActivity.class));
                break;
            case R.id.contact:
                startActivity(new Intent(MainActivity.this, ContactActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @OnItemClick(R.id.expandable_list_view)
    void onCategoryListClick(AdapterView<?> parent, int position) {


        if (!(espaResponse.categories.get(position).products == null)) {

            Intent intentProduct = new Intent(this,ProductActivity.class);
            intentProduct.putExtra("productPosition",position);
            startActivity(intentProduct);

        }else if(!(espaResponse.categories.get(position).subCategories == null)){

            Intent intentSubCategory = new Intent(this,SubCategoryActivity.class);

            intentSubCategory.putExtra("subCategoryPosition", position);
            startActivity(intentSubCategory);
        }
    }

    @Override
    public void onNewsClicked(News news) {
        Intent i = new Intent(this, NewsDetailActivity.class);
        i.putExtra("news", news);
        startActivity(i);
    }

    @OnClick(R.id.online_payment_layout)
    public void onPaymentClicked () {
        String url = "https://online.espagrup.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}