package com.saiev.bridge.page;

import com.saiev.bridge.theme.Theme;

public class About implements WebPage{
    Theme theme;

    @Override
    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @Override
    public void getContent() {
        System.out.println("About page in " + theme.getColor());
    }
}