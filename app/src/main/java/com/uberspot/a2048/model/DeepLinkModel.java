package com.uberspot.a2048.model;

import com.uberspot.a2048.managers.MenuManager;

/**
 * Created by Jose on 17/5/15.
 */
public class DeepLinkModel {
    private MenuManager.MenuType type;
    private String item;

    public DeepLinkModel(MenuManager.MenuType type, String item) {
        this.type = type;
        this.item = item;
    }

    public MenuManager.MenuType getType() {
        return type;
    }

    public void setType(MenuManager.MenuType type) {
        this.type = type;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
