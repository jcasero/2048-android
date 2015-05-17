package com.uberspot.a2048.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.uberspot.a2048.R;
import com.uberspot.a2048.adapters.models.NavigationDrawerAdapterItem;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Jose on 16/5/15.
 */
public class NavigationDrawerAdapter extends BaseAdapter {
    private List<NavigationDrawerAdapterItem> mItems;
    private LayoutInflater mInflater;

    public NavigationDrawerAdapter(Context context, List<NavigationDrawerAdapterItem> items) {
        this.mItems = items;
        mInflater = LayoutInflater.from(context);
    }

    @Override public int getCount() {
        return mItems.size();
    }

    @Override public Object getItem(int i) {
        return mItems.get(i);
    }

    @Override public long getItemId(int i) {
        return i;
    }

    @Override public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = mInflater.inflate(R.layout.navigation_drawer_item, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        NavigationDrawerAdapterItem item = mItems.get(i);
        holder.title.setText(item.getText());
        holder.image.setImageResource(item.getIcon());

        return view;
    }

    static class ViewHolder {
        @InjectView(R.id.navigation_drawer_item_title) TextView title;
        @InjectView(R.id.navigation_drawer_item_image) ImageView image;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
