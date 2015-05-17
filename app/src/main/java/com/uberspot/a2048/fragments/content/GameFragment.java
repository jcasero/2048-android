package com.uberspot.a2048.fragments.content;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.uberspot.a2048.R;
import com.uberspot.a2048.fragments.BaseFragment;
import com.uberspot.a2048.interfaces.OnChangeHomeIcon;
import com.uberspot.a2048.utils.Constants;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Jose on 16/5/15.
 */
public class GameFragment extends BaseFragment {
    @InjectView(R.id.game_web_view)    protected WebView mWebView;

    private Context mContext;
    private int mName;
    private String mPath;
    private OnChangeHomeIcon mCallback;

    public static GameFragment getInstance(int name, String path) {
        Bundle args = new Bundle();
        args.putInt(Constants.EXTRA_GAME_NAME, name);
        args.putString(Constants.EXTRA_GAME_PATH, path);

        GameFragment fragment = new GameFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (OnChangeHomeIcon) activity;
        } catch (ClassCastException e) {
            Log.e(Constants.TAG, e.toString());
        }
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        Bundle args = getArguments();
        if(args != null) {
            if(args.containsKey(Constants.EXTRA_GAME_NAME)) {
                mName = args.getInt(Constants.EXTRA_GAME_NAME);
            }

            if(args.containsKey(Constants.EXTRA_GAME_PATH)) {
                mPath = args.getString(Constants.EXTRA_GAME_PATH);
            }
        }

        mCallback.onChangeHomeIcon(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_main, container, false);
        ButterKnife.inject(this, view);

        setUpWebView();

        return view;
    }

    private void setUpWebView() {
        WebSettings settings = mWebView.getSettings();
        String packageName = getActivity().getPackageName();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setDatabasePath("/data/data/" + packageName + "/databases");
        mWebView.loadUrl(mPath);
    }



}
