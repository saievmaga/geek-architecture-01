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

        HttpResponse httpResponse = new HttpResponse();


        if (httpRequest.getMethod().equals("GET")) {

            if (!fileService.fileIsExist(httpRequest.getUrl())) {
                httpResponse.setCode("404");
                httpResponse.setAnswer("NOT_FOUND");
                httpResponse.setBody("<h1>Файл не найден!</h1>");
                socketService.writeResponse(httpResponse.toString());
                return;
            }

            httpResponse.setCode("200");
            httpResponse.setAnswer("OK");
            httpResponse.setBody(fileService.getFile(httpRequest.getUrl()));

            socketService.writeResponse(httpResponse.toString());
        } else if (httpRequest.getMethod().equals("POST")) {
            System.out.println("post");
            fileService.createFileAndWriteBody(httpRequest.getUrl(), httpRequest.getBody());
            System.out.println("canceled post");
            httpResponse.setCode("200");
            httpResponse.setAnswer("OK");

        } else {
            httpResponse.setContentType("405");
            httpResponse.setAnswer("METHOD_NOT_ALLOWED");
            httpResponse.setBody("<h1>Метод не поддерживается!</h1>");
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
