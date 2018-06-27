package com.happycoderz.espa.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.happycoderz.espa.R;
import com.happycoderz.espa.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GaleryAdapter extends RecyclerView.Adapter {


    private List<Photo> photos;
    private int item_layout;
    private Context context;

    public GaleryAdapter(List<Photo> photos, int item_layout, Context context) {
        this.photos = photos;
        this.item_layout = item_layout;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.galery_recycler_view_item,parent,false);

        itemHolder holder = new itemHolder(view, context, (ArrayList<Photo>) photos);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        String imageUrl = photos.get(position).getImageUrl();

        Picasso.with(context)
                .load(imageUrl)
                .into(((itemHolder) holder).itemImage);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class itemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.item_image)
        ImageView itemImage;
        @BindView(R.id.card_view)
        CardView cardView;
        Context context;

        ArrayList<Photo> photos = new ArrayList<Photo>();

        public itemHolder(View itemView, Context context, ArrayList<Photo> photos) {

            super(itemView);

            this.context = context;
            this.photos = photos;

            itemView.setOnClickListener(this);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
