package ru.geekbrains.utils;

import lombok.Data;

@Data
public class HttpResponse {
    String httpVersion = "HTTP/1.1";
    String code;
    String answer;
    String contentType = "Content-Type: text/html; charset=utf-8";
    String body;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(httpVersion).append(" ").append(code).append(" ").append(answer).append("\n")
                .append(contentType).append("\n")
                .append("\n")
                .append(body);
        return sb.toString();
    }
}