package com.uberspot.a2048.utils;

import com.uberspot.a2048.R;
import com.uberspot.a2048.adapters.models.GamesAdapterItem;
import com.uberspot.a2048.adapters.models.NavigationDrawerAdapterItem;
import com.uberspot.a2048.adapters.models.TipAdapterItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jose on 16/5/15.
 */
public class ResourcesUtils {

    public static List<NavigationDrawerAdapterItem> getMenuItems() {
        List<NavigationDrawerAdapterItem> items = new ArrayList<>();

        items.add(new NavigationDrawerAdapterItem(R.string.games, R.drawable.ic_launcher));
        items.add(new NavigationDrawerAdapterItem(R.string.tips_and_tricks, R.drawable.ic_launcher));
        items.add(new NavigationDrawerAdapterItem(R.string.history, R.drawable.ic_launcher));
        items.add(new NavigationDrawerAdapterItem(R.string.algorithm, R.drawable.ic_launcher));

        return items;
    }

    public static List<GamesAdapterItem> getGamesVariants() {
        List<GamesAdapterItem> items = new ArrayList<>();

        items.add(new GamesAdapterItem(R.string.original, R.color.material_deep_purple_500, "file:///android_asset/original/index.html"));
        items.add(new GamesAdapterItem(R.string.undo_2048, R.color.material_red_500, "file:///android_asset/undo/index.html"));
        items.add(new GamesAdapterItem(R.string.two_three_2048, R.color.material_pink_500, "file:///android_asset/multiple/size2x3.html"));
        items.add(new GamesAdapterItem(R.string.size_5_2048, R.color.material_indigo_500, "file:///android_asset/multiple/size5.html"));
        items.add(new GamesAdapterItem(R.string.size_6_20, R.color.material_deep_teal_500, "file:///android_asset/multiple/size6.html"));
        items.add(new GamesAdapterItem(R.string.dont_make_2048, R.color.material_purple_500, "file:///android_asset/multiple/dontmake2048.html"));
        items.add(new GamesAdapterItem(R.string.fibonacci, R.color.material_blue_500, "file:///android_asset/multiple/fibonacci.html"));
        items.add(new GamesAdapterItem(R.string.finals, R.color.material_green_500, "file:///android_asset/multiple/finals.html"));
        items.add(new GamesAdapterItem(R.string.zero, R.color.material_light_blue_500, "file:///android_asset/multiple/0.html"));
        items.add(new GamesAdapterItem(R.string.sixty_four_k, R.color.material_cyan_500, "file:///android_asset/multiple/65536.html"));

        return items;
    }

    public static List<TipAdapterItem> getTips() { //This should be get from a web service or something similar to do a deep link
        List<TipAdapterItem> items = new ArrayList<>();

        items.add(new TipAdapterItem(R.string.tip_one_title, R.string.tip_one_subtitle));
        items.add(new TipAdapterItem(R.string.tip_two_title, R.string.tip_two_subtitle));
        items.add(new TipAdapterItem(R.string.tip_three_title, R.string.tip_three_subtitle));
        items.add(new TipAdapterItem(R.string.tip_four_title, R.string.tip_four_subtitle));
        items.add(new TipAdapterItem(R.string.tip_five_title, R.string.tip_five_subtitle));
        items.add(new TipAdapterItem(R.string.tip_six_title, R.string.tip_six_subtitle));
        items.add(new TipAdapterItem(R.string.tip_seven_title, R.string.tip_seven_subtitle));

        return items;
    }
}
