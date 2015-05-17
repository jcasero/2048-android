package com.uberspot.a2048.adapters.models;

/**
 * Created by Jose on 16/5/15.
 */
public class NavigationDrawerAdapterItem {
    int text;
    int icon;

    public NavigationDrawerAdapterItem(int text, int icon) {
        this.text = text;
        this.icon = icon;
    }

    public int getText() {
        return text;
    }

    public void setText(int text) {
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
