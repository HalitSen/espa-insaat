package com.happycoderz.espa.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.happycoderz.espa.R;
import com.happycoderz.espa.model.Category;
import com.happycoderz.espa.model.Product;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RelatedProductsAdapter extends ArrayAdapter<Product>{

    public RelatedProductsAdapter(Context context, ArrayList<Product> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final RelatedProductsAdapter.ViewHolder holder;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
           convertView= layoutInflater.inflate(R.layout.product_detail_list_item,parent,false);
           holder = new RelatedProductsAdapter.ViewHolder(convertView);
           convertView.setTag(holder);
        }else{
            holder = (RelatedProductsAdapter.ViewHolder) convertView.getTag();
        }
        final Product product = getItem(position);
        holder.name.setText(product.getTitle());
        holder.code.setText("#" +product.getCode());

        return convertView;
    }

    public static class ViewHolder {
        @BindView(R.id.name_text_view)
        TextView name;
        @BindView(R.id.code_text_view)
        TextView code;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}