package com.uberspot.a2048.managers;

import android.net.Uri;
import android.support.v4.app.Fragment;

import com.uberspot.a2048.fragments.content.AlgorithmFragment;
import com.uberspot.a2048.fragments.content.GamesGridFragment;
import com.uberspot.a2048.fragments.content.HistoryFragment;
import com.uberspot.a2048.fragments.content.TipsFragment;
import com.uberspot.a2048.model.DeepLinkModel;

/**
 * Created by Jose on 16/5/15.
 */
public class MenuManager {

    public enum MenuType { HEADER, GAMES, TIPS, HISTORY, ALGORITHM }

    private String HTTP_PATTERN = "http://";
    private String HTTPS_PATTERN = "https://";

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

    public DeepLinkModel getInitialItem(Uri uri) {
        if(uri == null) return new DeepLinkModel(MenuType.GAMES, "");

        String data = uri.toString();

        data = data.contains(HTTP_PATTERN) ? data.replace(HTTP_PATTERN, "") : data;
        data = data.contains(HTTP_PATTERN) ? data.replace(HTTPS_PATTERN, "") : data;

        String strType = "";

        String[] segments = data.split("/");
        if(segments.length > 1) { //This check the first segment. It could be variants, tips, ...
            strType = segments[1];
        }

        MenuType result;

        switch (strType) {
            case "variants": result = MenuType.GAMES; break;
            case "tips": result = MenuType.TIPS; break;
            case "history": result = MenuType.HISTORY; break;
            case "algorithm": result = MenuType.ALGORITHM; break;
            default: result = MenuType.GAMES;
        }

        String item = "";

        if(segments.length > 2) { //This check the first segment. It could be variants, tips, ...
            item = segments[2];
        }

        return new DeepLinkModel(result, item);
    }
}
