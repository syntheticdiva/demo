package com.example.server.service;

public class BrowserWindow {
    private int x;
    private int y;
    private int width;
    private int height;
    private double mouseX;
    private double mouseY;

    public BrowserWindow(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 400;
        this.height = 400;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getMouseX() {
        return mouseX;
    }

    public double getMouseY() {
        return mouseY;
    }

    public void updateCoordinates(int x, int y) {
        this.mouseX = x;
        this.mouseY = y;
    }
}