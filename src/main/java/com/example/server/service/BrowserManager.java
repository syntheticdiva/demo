package com.example.server.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrowserManager {
    private static final int BROWSER_COUNT = 3;
    private static final int BROWSER_WINDOW_SIZE = 400;
    private static final int WAIT_TIME_SECONDS = 5;
    private static final int MOUSE_MOVE_FREQUENCY = 50; // 50 раз в секунду

    private final OperatingSystemUtil operatingSystemUtil;
    private final List<BrowserWindow> browserWindows;

    public BrowserManager(OperatingSystemUtil operatingSystemUtil) {
        this.operatingSystemUtil = operatingSystemUtil;
        this.browserWindows = new ArrayList<>();
    }

    public void startBrowserTracker() {
        // Открыть 3 независимых окна браузера
        openBrowserWindows();

        // Подключить 3 реальных указателя мыши и установить их в центр браузеров
        attachMousePointers();

        // Начать движение указателей мыши по круговой траектории
        startMouseTracker();
    }

    public void stopBrowserTracker() {
        // Остановить движение указателей мыши
        stopMouseTracker();

        // Закрыть окна браузеров
        closeBrowserWindows();
    }

    private void openBrowserWindows() {
        for (int i = 0; i < BROWSER_COUNT; i++) {
            BrowserWindow window = new BrowserWindow(i * BROWSER_WINDOW_SIZE, i * BROWSER_WINDOW_SIZE);
            browserWindows.add(window);
            operatingSystemUtil.openBrowser(window.getX(), window.getY(), BROWSER_WINDOW_SIZE, BROWSER_WINDOW_SIZE);
        }
    }

    private void attachMousePointers() {
        for (BrowserWindow window : browserWindows) {
            operatingSystemUtil.attachMousePointer(window.getX() + BROWSER_WINDOW_SIZE / 2, window.getY() + BROWSER_WINDOW_SIZE / 2);
        }
    }

    private void startMouseTracker() {
        // Ждем 5 секунд, затем начинаем двигать указатели мыши по круговой траектории
        ThreadUtil.sleep(WAIT_TIME_SECONDS * 1000);

        double angle = 0;
        while (true) {
            for (BrowserWindow window : browserWindows) {
                int x = (int) (window.getX() + BROWSER_WINDOW_SIZE / 2 + BROWSER_WINDOW_SIZE / 2 * Math.cos(Math.toRadians(angle)));
                int y = (int) (window.getY() + BROWSER_WINDOW_SIZE / 2 + BROWSER_WINDOW_SIZE / 2 * Math.sin(Math.toRadians(angle)));
                operatingSystemUtil.moveMousePointer(x, y);
                window.updateCoordinates(x, y);
            }
            angle += 360.0 / (BROWSER_COUNT * MOUSE_MOVE_FREQUENCY);
            ThreadUtil.sleep(1000 / MOUSE_MOVE_FREQUENCY);
        }
    }

    private void stopMouseTracker() {
        // Остановить движение указателей мыши
        operatingSystemUtil.stopMouseTracking();
    }

    private void closeBrowserWindows() {
        // Закрыть окна браузеров
        for (BrowserWindow window : browserWindows) {
            operatingSystemUtil.closeBrowser(window.getX(), window.getY());
        }
        browserWindows.clear();
    }
}