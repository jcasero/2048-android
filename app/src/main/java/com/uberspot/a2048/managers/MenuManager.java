package com.uberspot.a2048.managers;

import android.support.v4.app.Fragment;

import com.uberspot.a2048.fragments.content.AlgorithmFragment;
import com.uberspot.a2048.fragments.content.GamesGridFragment;
import com.uberspot.a2048.fragments.content.HistoryFragment;
import com.uberspot.a2048.fragments.content.TipsFragment;

/**
 * Created by Jose on 16/5/15.
 */
public class MenuManager {
    public enum MenuType { HEADER, GAMES, TIPS, HISTORY, ALGORITHM}
    public MenuManager() {

    }

    public Fragment getItemFragment(MenuType menu) {

        Fragment fragment = GamesGridFragment.getInstance();
        switch (menu) {
            case GAMES: fragment = GamesGridFragment.getInstance(); break;
            case TIPS: fragment = TipsFragment.getInstance(); break;
            case HISTORY: fragment = HistoryFragment.getInstance(); break;
            case ALGORITHM: fragment = AlgorithmFragment.getInstance(); break;
        }
        return fragment;
    }
}
