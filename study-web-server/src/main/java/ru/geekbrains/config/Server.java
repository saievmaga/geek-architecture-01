package ru.geekbrains.config;



import lombok.extern.slf4j.Slf4j;
import ru.geekbrains.service.ClientHandlerImpl;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.SocketService;
import ru.geekbrains.service.SocketServiceFactory;
import ru.geekbrains.utils.RequestParser;
import ru.geekbrains.utils.RequestParserFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class Server {
    ServerSocket serverSocket;

    public Server() {
        try {
            this.serverSocket = new ServerSocket(Init.getPORT());
            log.info("Server started on port : " + Init.getPORT());
            while (true) {
                Socket socket = serverSocket.accept();
                FileService fileService = new FileService();
                log.info("New client connected!");
                new Thread(new ClientHandlerImpl(SocketServiceFactory.createSocketService(socket),
                        RequestParserFactory.createRequestParser(),
                        fileService))
                        .start();
            }
        } catch (IOException e) {
            log.warn(e.getMessage());
        }
    }
}
