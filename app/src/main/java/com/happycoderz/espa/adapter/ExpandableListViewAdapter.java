package com.happycoderz.espa.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.happycoderz.espa.R;
import com.happycoderz.espa.model.Category;
import com.happycoderz.espa.model.EspaResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExpandableListViewAdapter extends ArrayAdapter<Category>{

    public ExpandableListViewAdapter(Context context, ArrayList<Category> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ExpandableListViewAdapter.ViewHolder holder;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
           convertView= layoutInflater.inflate(R.layout.main_expandable_list_item,parent,false);
           holder = new ExpandableListViewAdapter.ViewHolder(convertView);
           convertView.setTag(holder);
        }else{
            holder = (ExpandableListViewAdapter.ViewHolder) convertView.getTag();
        }
        final Category category = getItem(position);
        holder.itemText.setText(category.getTitle());
        int count = (category.getProducts() == null)?category.getSubCategories().size() : category.getProducts().size();
        holder.count.setText(String.valueOf(count));

        return convertView;
    }

    public static class ViewHolder {
        @BindView(R.id.sub_cat_item_text_view)
        TextView itemText;
        @BindView(R.id.count)
        TextView count;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}