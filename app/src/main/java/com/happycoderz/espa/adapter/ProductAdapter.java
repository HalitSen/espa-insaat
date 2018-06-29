package com.happycoderz.espa.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.happycoderz.espa.R;
import com.happycoderz.espa.model.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductAdapter extends ArrayAdapter<Product>{
    public ProductAdapter( Context context, ArrayList<Product> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ProductAdapter.ViewHolder holder;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView= layoutInflater.inflate(R.layout.product_list_item,parent,false);
            holder = new ProductAdapter.ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ProductAdapter.ViewHolder) convertView.getTag();
        }
        final Product product = getItem(position);
        holder.productNameText.setText(product.getTitle());
        holder.productCodeText.setText("#" + product.getCode());

        Picasso.with(getContext())
                .load(product.getImage())
                .into(holder.productImage);

        return convertView;
    }

    public static class ViewHolder {
        @BindView(R.id.product_item_image)
        ImageView productImage;
        @BindView(R.id.product_item_name_text)
        TextView productNameText;
        @BindView(R.id.product_item_code_text)
        TextView productCodeText;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
