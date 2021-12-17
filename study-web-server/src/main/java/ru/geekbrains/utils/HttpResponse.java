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

    public static HttpResponseBuilder HttpResponseBuilder() {
        return new HttpResponseBuilder();
    }

    public static class HttpResponseBuilder {
        private HttpResponse httpResponse;

        private HttpResponseBuilder() {
            this.httpResponse = new HttpResponse();
        }

        public HttpResponseBuilder httpVersion(String version) {
            this.httpResponse.httpVersion = version;
            return this;
        }

        public HttpResponseBuilder code(String code) {
            this.httpResponse.code = code;
            return this;
        }

        public HttpResponseBuilder answer(String answer) {
            this.httpResponse.code = answer;
            return this;
        }

        public HttpResponseBuilder body(String body) {
            this.httpResponse.body = body;
            return this;
        }

        public HttpResponse build() {
            return this.httpResponse;
        }
    }
}