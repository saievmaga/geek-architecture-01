package ru.geekbrains.utils;

public class RequestParserFactory {
    public static RequestParser createRequestParser() {
        return new RequestParserImpl();
    }
}
