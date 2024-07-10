package com.example.server.service;

import org.springframework.stereotype.Service;

@Service
public class WebSocketServer {
    private WebSocketServerContainer serverContainer;

    public void start(int port) {
        // Создание и настройка WebSocket-сервера
        serverContainer = new WebSocketServerContainer();
        serverContainer.start(port);
    }

    public void stop() {
        // Остановка WebSocket-сервера
        serverContainer.stop();
    }

    private class WebSocketServerContainer {
        private WebSocketServer webSocketServer;

        public void start(int port) {
            // Реализуйте логику запуска WebSocket-сервера
            // Например, можно использовать библиотеку Java WebSocket API (JSR-356)
            // или фреймворк, такой как Spring WebSocket
            webSocketServer = new WebSocketServer();
            webSocketServer.start(port);
        }

        public void stop() {
            // Реализуйте логику остановки WebSocket-сервера
            webSocketServer.stop();
        }
    }
}