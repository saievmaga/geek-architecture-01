package com.saiev.bridge;


import com.saiev.bridge.page.About;
import com.saiev.bridge.page.Careers;
import com.saiev.bridge.theme.DarkTheme;
import com.saiev.bridge.theme.Theme;

public class Main {
    public static void main(String[] args) {
        Theme darkTheme = new DarkTheme();
        About about = new About();
        about.setTheme(darkTheme);
        Careers careers = new Careers();
        careers.setTheme(darkTheme);

        about.getContent();
        careers.getContent();

//        output
//        About page in Dark theme
//        Careers page in Dark theme

    }
}