package com.uberspot.a2048.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.uberspot.a2048.interfaces.OnMenuItemSelected;
import com.uberspot.a2048.R;
import com.uberspot.a2048.adapters.NavigationDrawerAdapter;
import com.uberspot.a2048.adapters.models.NavigationDrawerAdapterItem;
import com.uberspot.a2048.utils.Constants;
import com.uberspot.a2048.utils.ResourcesUtils;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Jose on 16/5/15.
 */
public class NavigationDrawerFragment extends Fragment implements AdapterView.OnItemClickListener {
    @InjectView(R.id.navigation_drawer_list) protected ListView mListView;

    private Context mContext;
    private OnMenuItemSelected mCallback;

    public NavigationDrawerFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.navigation_drawer_main, container, false);
        ButterKnife.inject(this, view);
        view.setFitsSystemWindows(true); //Allow to draw this view on top of the toolbar

        mContext = getActivity();

        if(mContext == null) return view;

        List<NavigationDrawerAdapterItem> items = ResourcesUtils.getMenuItems();
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.navigation_drawer_header, mListView, false);
        mListView.addHeaderView(header, null, false);
        mListView.setAdapter(new NavigationDrawerAdapter(mContext, items));
        mListView.setOnItemClickListener(this);

        return view;
    }

    @Override public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mCallback.onMenuItemSelected(i);
    }

    @Override public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (OnMenuItemSelected) activity;
        } catch (ClassCastException e) {
            Log.e(Constants.TAG, e.toString());
        }
    }
}
