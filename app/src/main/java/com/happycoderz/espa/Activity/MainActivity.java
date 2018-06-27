package com.happycoderz.espa.Activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView;
import com.happycoderz.espa.R;
import com.happycoderz.espa.adapter.ExpandableListViewAdapter;
import com.happycoderz.espa.adapter.NewsAdapter;
import com.happycoderz.espa.helper.CacheHelper;
import com.happycoderz.espa.model.Category;
import com.happycoderz.espa.model.EspaResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;
    CacheHelper cacheHelper;
    EspaResponse espaResponse;

    @BindView(R.id.container)
    ViewPager mViewPager;
    @BindView(R.id.circle_1)
    ImageView circleOne;
    @BindView(R.id.circle_2)
    ImageView circleTwo;
    @BindView(R.id.circle_3)
    ImageView circleThree;

    NewsAdapter newsAdapter;
    ExpandableListViewAdapter expandableListViewAdapter;

    ArrayList<Category> categories;

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

        Log.v("espa from Cache",espaResponse.categories.get(0).getTitle());

        newsAdapter = new NewsAdapter(this);
        mViewPager.setAdapter(newsAdapter);

        mViewPager.addOnPageChangeListener(this);
        categories = new ArrayList<Category>();
        categories = espaResponse.categories;

        expandableListViewAdapter = new ExpandableListViewAdapter(this,categories);
        expandablListView.setAdapter(expandableListViewAdapter);
        expandablListView.setExpanded(true);
        expandablListView.setFocusable(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.about_us:
                startActivity(new Intent(MainActivity.this,AboutUsActivity.class));
                finish();
                break;
            case R.id.galery:
                startActivity(new Intent(MainActivity.this,GaleryActivity.class));
                finish();
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

        switch (position) {
            case 0:
                circleOne.setImageResource(R.drawable.full_circle_image);
                circleTwo.setImageResource(R.drawable.empty_circle_image);
                circleThree.setImageResource(R.drawable.empty_circle_image);
                break;
            case 1:
                circleOne.setImageResource(R.drawable.empty_circle_image);
                circleTwo.setImageResource(R.drawable.full_circle_image);
                circleThree.setImageResource(R.drawable.empty_circle_image);
                break;
            case 2:
                circleOne.setImageResource(R.drawable.empty_circle_image);
                circleTwo.setImageResource(R.drawable.empty_circle_image);
                circleThree.setImageResource(R.drawable.full_circle_image);
                break;
        }
    }
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}