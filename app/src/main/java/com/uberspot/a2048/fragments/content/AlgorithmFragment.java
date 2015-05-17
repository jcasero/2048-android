package com.uberspot.a2048.fragments.content;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uberspot.a2048.R;
import com.uberspot.a2048.fragments.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by Jose on 16/5/15.
 */
public class AlgorithmFragment extends BaseFragment {

    public static Fragment getInstance() {
        return new AlgorithmFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.algorithm_main, container, false);
        ButterKnife.inject(this, view);

        return view;
    }
}
