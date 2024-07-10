package com.example.client.service;


import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@Component
public class WebSocketClient {
    private final StompSessionHandler stompSessionHandler;
    private final WebSocketStompClient stompClient;
    private StompSession stompSession;

    public WebSocketClient(StompSessionHandler stompSessionHandler, WebSocketStompClient stompClient) {
        this.stompSessionHandler = stompSessionHandler;
        this.stompClient = stompClient;
    }

    public void connect(String serverIp, int serverPort) {
        String url = "ws://" + serverIp + ":" + serverPort + "/websocket";
        stompClient.connect(url, stompSessionHandler)
                .addCallback(this::setStompSession, ex -> {
                    // Обработка ошибок подключения
                });
    }

    private void setStompSession(StompSession session) {
        this.stompSession = session;
    }

    public void startMouseTracker() {
        stompSession.subscribe("/topic/mouse-events", stompSessionHandler);
    }

    public void stopMouseTracker() {
        stompSession.disconnect();
    }
}
