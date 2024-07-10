package com.example.client.service;

import com.example.common.MouseCoordinate;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class MyStompSessionHandler implements StompSessionHandler {
    private final MouseEventService mouseEventService;

    public MyStompSessionHandler(MouseEventService mouseEventService) {
        this.mouseEventService = mouseEventService;
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return MouseCoordinate.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        if (payload instanceof MouseCoordinate) {
            MouseCoordinate mouseCoordinate = (MouseCoordinate) payload;
            // Обработка события движения мыши
            mouseEventService.saveMouseCoordinate(mouseCoordinate);
            // Сохранение координат в БД или отправка на сервер
        }
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        // Обработка успешного подключения
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        // Обработка исключений
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {
        // Обработка ошибок транспорта
    }
}

