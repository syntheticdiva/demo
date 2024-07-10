package com.example.client.repository;

import com.example.common.MouseCoordinate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MouseCoordinateRepository extends JpaRepository<MouseCoordinate, Long> {
    // Определите необходимые методы для работы с данными мыши
}
