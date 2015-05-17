package com.uberspot.a2048.adapters.models;

/**
 * Created by Jose on 16/5/15.
 */
public class GamesAdapterItem {
    int title;
    int color;
    String path;

    public GamesAdapterItem(int title, int color, String path) {
        this.title = title;
        this.color = color;
        this.path = path;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
