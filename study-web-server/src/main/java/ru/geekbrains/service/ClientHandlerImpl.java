package ru.geekbrains.service;

import ru.geekbrains.utils.HttpRequest;
import ru.geekbrains.utils.HttpResponse;
import ru.geekbrains.utils.RequestParser;

import java.io.IOException;
import java.util.Deque;

public class ClientHandlerImpl implements Runnable {

    private final SocketService socketService;
    private final RequestParser requestParser;
    private final FileService fileService;

    public ClientHandlerImpl(SocketService socketService, RequestParser requestParser, FileService fileService) {
        this.socketService = socketService;
        this.requestParser = requestParser;
        this.fileService = fileService;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest httpRequest = requestParser.parseRequest(rawRequest);


        if (httpRequest.getMethod().equals("GET")) {

            if (!fileService.fileIsExist(httpRequest.getUrl())) {
                HttpResponse httpResponse = HttpResponse.HttpResponseBuilder()
                        .code("404")
                        .answer("NOT_FOUND")
                        .body("<h1>Файл не найден!</h1>")
                        .build();
                socketService.writeResponse(httpResponse.toString());
                return;
            }

            HttpResponse httpResponse = HttpResponse.HttpResponseBuilder()
                    .code("404")
                    .answer("NOT_FOUND")
                    .body("<h1>Файл не найден!</h1>")
                    .build();

            socketService.writeResponse(httpResponse.toString());
        } else if (httpRequest.getMethod().equals("POST")) {

            fileService.createFileAndWriteBody(httpRequest.getUrl(), httpRequest.getBody());
            HttpResponse httpResponse = HttpResponse.HttpResponseBuilder()
                    .code("404")
                    .answer("NOT_FOUND")
                    .body("<h1>Файл не найден!</h1>")
                    .build();
        } else {
            HttpResponse httpResponse = HttpResponse.HttpResponseBuilder()
                    .code("405")
                    .answer("METHOD_NOT_ALLOWED")
                    .body("<h1>Метод не поддерживается!</h1>")
                    .build();
            socketService.writeResponse(httpResponse.toString());
            return;
        }
        try {
            socketService.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        System.out.println("Client disconnected!");
    }
}
