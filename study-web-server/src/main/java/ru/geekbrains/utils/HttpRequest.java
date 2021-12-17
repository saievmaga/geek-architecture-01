package ru.geekbrains.utils;

import java.util.Map;

public class HttpRequest {

    private String method;

    private String url;

    private Map<String, String> headers;

    private String body;

    public HttpRequest() {

    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }


    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", headers=" + headers +
                ", body='" + body + '\'' +
                '}';
    }

    public static MyHttpRequestBuilder createHttpRequest() {
        return new MyHttpRequestBuilder();
    }

    public static class MyHttpRequestBuilder {
        private final HttpRequest httpRequest;

        private MyHttpRequestBuilder() {
            this.httpRequest = new HttpRequest();
        }

        public MyHttpRequestBuilder method(String method) {
            this.httpRequest.method = method;
            return this;
        }

        public MyHttpRequestBuilder url(String url) {
            this.httpRequest.url = url;
            return this;
        }

        public MyHttpRequestBuilder headers(Map<String, String> headers) {
            this.httpRequest.headers = headers;
            return this;
        }

        public MyHttpRequestBuilder body(String body) {
            this.httpRequest.body = body;
            return this;
        }

        public HttpRequest build () {
            return this.httpRequest;
        }
    }
}