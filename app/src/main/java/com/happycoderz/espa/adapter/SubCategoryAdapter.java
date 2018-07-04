package com.happycoderz.espa.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.happycoderz.espa.R;
import com.happycoderz.espa.model.Category;
import com.happycoderz.espa.model.SubCategory;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubCategoryAdapter extends ArrayAdapter<SubCategory>{

    public SubCategoryAdapter(Context context, ArrayList<SubCategory> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final SubCategoryAdapter.ViewHolder holder;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView= layoutInflater.inflate(R.layout.sub_category_list_item,parent,false);
            holder = new SubCategoryAdapter.ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (SubCategoryAdapter.ViewHolder) convertView.getTag();
        }
        final SubCategory subCategory = getItem(position);
        holder.subCatItemText.setText(subCategory.getTitle());
        holder.count.setText(String.valueOf(subCategory.getProduct().size()));
        return convertView;
    }


    public static class ViewHolder {
        @BindView(R.id.sub_cat_item_text_view)
        TextView subCatItemText;
        @BindView(R.id.count)
        TextView count;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
