package com.example.client.service;

import com.example.client.repository.MouseCoordinateRepository;
import com.example.common.MouseCoordinate;
import org.springframework.stereotype.Service;

@Service
public class MouseEventService {
    private final MouseCoordinateRepository repository;

    public MouseEventService(MouseCoordinateRepository repository) {
        this.repository = repository;
    }

    public void saveMouseCoordinate(MouseCoordinate coordinate) {
        repository.save(coordinate);
        // Или отправить координаты на сервер
    }
}
