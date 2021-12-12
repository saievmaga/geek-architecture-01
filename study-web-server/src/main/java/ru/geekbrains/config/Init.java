package ru.geekbrains.config;

public class Init {
    static private  String ROOT_PATH;
    static private  int PORT;

    public Init(String[] args) {
        ROOT_PATH = "/Users/saiev/Desktop/DesktopFiles/geek-architecture-01/www";
        PORT = 8080;

        for (String arg : args) {
            if(arg.startsWith("path")) {
                ROOT_PATH = arg.split("=")[1];
            }
            if(arg.startsWith("port")) {
                PORT = Integer.parseInt(arg.split("=")[1]);
            }
        }
    }

    static public String getROOT_PATH() {
        return ROOT_PATH;
    }

    static public int getPORT() {
        return PORT;
    }
}
