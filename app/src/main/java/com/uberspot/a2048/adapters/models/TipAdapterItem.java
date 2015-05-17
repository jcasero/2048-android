package com.uberspot.a2048.adapters.models;

/**
 * Created by Jose on 16/5/15.
 */
public class TipAdapterItem {
    int title;
    int body;

    public TipAdapterItem(int title, int body) {
        this.title = title;
        this.body = body;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }
}
