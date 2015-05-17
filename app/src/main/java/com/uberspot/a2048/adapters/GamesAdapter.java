package com.uberspot.a2048.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.uberspot.a2048.R;
import com.uberspot.a2048.adapters.models.GamesAdapterItem;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Jose on 16/5/15.
 */
public class GamesAdapter extends BaseAdapter {
    private List<GamesAdapterItem> mItems;
    private LayoutInflater mInflater;
    private Context mContext;

    public GamesAdapter(Context context, List<GamesAdapterItem> items) {
        mItems = items;
        mInflater = LayoutInflater.from(context);
        mContext = context;
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
            view = mInflater.inflate(R.layout.games_grid_item, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        GamesAdapterItem item = mItems.get(i);
        holder.title.setText(item.getTitle());
        holder.image.setBackgroundResource(item.getColor());


        return view;
    }

    static class ViewHolder {
        @InjectView(R.id.games_item_title)  TextView title;
        @InjectView(R.id.games_item_image)  ImageView image;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
