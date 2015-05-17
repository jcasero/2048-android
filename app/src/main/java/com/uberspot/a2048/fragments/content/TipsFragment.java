package com.uberspot.a2048.fragments.content;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.uberspot.a2048.R;
import com.uberspot.a2048.activities.TipInfoActivity;
import com.uberspot.a2048.adapters.TipsAdapter;
import com.uberspot.a2048.adapters.models.TipAdapterItem;
import com.uberspot.a2048.fragments.BaseFragment;
import com.uberspot.a2048.utils.Constants;
import com.uberspot.a2048.utils.ResourcesUtils;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Jose on 16/5/15.
 */
public class TipsFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    @InjectView(R.id.tips_list) protected ListView mListView;

    private Context mContext;
    private List<TipAdapterItem> mItems;

    public static Fragment getInstance() {
        return new TipsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tips_main, container, false);
        ButterKnife.inject(this, view);

        mContext = getActivity();

        if(mContext == null) return view;

        mItems = ResourcesUtils.getTips();
        mListView.setAdapter(new TipsAdapter(mContext, mItems));
        mListView.setOnItemClickListener(this);

        return view;
    }

    @Override public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TipAdapterItem item = mItems.get(i);

        Intent intent = new Intent(mContext, TipInfoActivity.class);
        intent.putExtra(Constants.EXTRA_TIP_TITLE_ID, item.getTitle());
        intent.putExtra(Constants.EXTRA_TIP_SUBTITLE_ID, item.getBody());
        startActivity(intent);
    }
}
