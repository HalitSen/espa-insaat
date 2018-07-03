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
    NewsClickListener listener;

    public NewsAdapter(Context context) {
        this.context = context;
        cacheHelper = new CacheHelper(context);
        espaResponse = cacheHelper.getObject("espaInfo", EspaResponse.class);
    }

    public void setListener(NewsClickListener listener) {
        this.listener = listener;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        LayoutInflater inflater = LayoutInflater.from(context);

        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.espa_news_layout, container, false);

        TextView newsTitle = (TextView) layout.findViewById(R.id.espa_news_text);
        ImageView newsImage = (ImageView) layout.findViewById(R.id.espa_news_image);
        newsTitle.setText(espaResponse.news.get(position).getTitle());
        String imageUrl = espaResponse.news.get(position).getImage();
        Picasso.with(context)
                .load(imageUrl)
                .into(newsImage);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onNewsClicked(espaResponse.news.get(position));
            }
        });
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

    public interface NewsClickListener {
        void onNewsClicked (News news);
    }
}


