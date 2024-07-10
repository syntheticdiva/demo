package com.example.common;


import java.sql.Timestamp;

public class MouseCoordinate {
    private double x;
    private double y;
    private Timestamp timestamp;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    // getters, setters, constructors

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public MouseCoordinate(double x, double y, Timestamp timestamp) {
        this.x = x;
        this.y = y;
        this.timestamp = timestamp;
    }

}