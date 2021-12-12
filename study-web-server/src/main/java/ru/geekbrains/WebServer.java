package ru.geekbrains;


import ru.geekbrains.config.Init;
import ru.geekbrains.config.Server;

public class WebServer {

    public static void main(String[] args) {
        new Init(args);
        new Server();
    }
}
