package com.happycoderz.espa.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.happycoderz.espa.R;
import com.happycoderz.espa.helper.CacheHelper;
import com.happycoderz.espa.model.EspaResponse;
import com.happycoderz.espa.model.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends PagerAdapter {

    EspaResponse espaResponse = new EspaResponse();
    ArrayList<News> news;
    private Context context;
    CacheHelper cacheHelper;

    public NewsAdapter(Context context) {
        this.context = context;
        cacheHelper = new CacheHelper(context);
        espaResponse = cacheHelper.getObject("espaInfo", EspaResponse.class);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);

        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.espa_news_layout, container, false);

        TextView newsTitle = (TextView) layout.findViewById(R.id.espa_news_text);
        ImageView newsImage = (ImageView) layout.findViewById(R.id.espa_news_image);
        newsTitle.setText(espaResponse.news.get(position).getTitle());
        String imageUrl = espaResponse.news.get(position).getImage();
        Picasso.with(context)
                .load(imageUrl)
                .into(newsImage);

        container.addView(layout);
        return layout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return espaResponse.news.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
