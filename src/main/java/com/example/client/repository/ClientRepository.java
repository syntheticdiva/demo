package com.example.client.repository;

import com.example.common.MouseCoordinate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//@Repository
//public class ClientRepository {
//    private final JdbcTemplate jdbcTemplate;
//
//    public ClientRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public void saveMouseCoordinate(MouseCoordinate coordinate) {
//        String sql = "INSERT INTO mouse_coordinates (x, y, timestamp) VALUES (?, ?, ?)";
//        jdbcTemplate.update(sql, coordinate.getX(), coordinate.getY(), coordinate.getTimestamp());
//    }
//
//    public List<MouseCoordinate> getLogSortedBy(String sortBy) {
//        String sql = "SELECT x, y, timestamp FROM mouse_coordinates ORDER BY " + sortBy;
//        return jdbcTemplate.query(sql, (rs, rowNum) -> new MouseCoordinate(
//                rs.getDouble("x"),
//                rs.getDouble("y"),
//                rs.getTimestamp("timestamp")
//        ));
//    }
//}

@Repository
public class ClientRepository {
    private final List<MouseCoordinate> mouseLog = new ArrayList<>();

    public void saveMouseCoordinate(MouseCoordinate coordinate) {
        mouseLog.add(coordinate);
    }

    public List<MouseCoordinate> getLogSortedBy(String sortBy) {
        return mouseLog.stream()
                .sorted(Comparator.comparing(MouseCoordinate::getTimestamp))
                .collect(Collectors.toList());
    }
}
