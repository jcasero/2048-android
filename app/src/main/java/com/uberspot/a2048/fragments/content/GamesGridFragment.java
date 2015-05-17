package com.uberspot.a2048.fragments.content;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.uberspot.a2048.R;
import com.uberspot.a2048.adapters.GamesAdapter;
import com.uberspot.a2048.adapters.models.GamesAdapterItem;
import com.uberspot.a2048.fragments.BaseFragment;
import com.uberspot.a2048.utils.ResourcesUtils;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Jose on 16/5/15.
 */
public class GamesGridFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    @InjectView(R.id.games_grid)    protected GridView mGridView;

    private Context mContext;
    private List<GamesAdapterItem> mItems;

    public static GamesGridFragment getInstance() {
        Bundle args = new Bundle();
//        args.putString(Constants.EXTRA_GAME_NAME, game);

        GamesGridFragment fragment = new GamesGridFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.games_grid_main, container, false);
        ButterKnife.inject(this, view);
//        view.setFitsSystemWindows(true); //Allow to draw this view on top of the toolbar

        mContext = getActivity();

        if(mContext == null) return view;

        mItems = ResourcesUtils.getGamesVariants();
        mGridView.setAdapter(new GamesAdapter(mContext, mItems));
        mGridView.setOnItemClickListener(this);

        return view;
    }

    @Override public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        GamesAdapterItem item = mItems.get(i);
        GameFragment fragment = GameFragment.getInstance(item.getTitle(), item.getPath());

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.activity_main_content, fragment);
        transaction.addToBackStack(fragment.getClass().toString());
        transaction.commit();
    }
}
