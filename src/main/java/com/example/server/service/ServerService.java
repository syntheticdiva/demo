package com.example.server.service;


import com.example.config.ServerConfig;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class ServerService {
    @Getter
    private final ServerConfig config;
    private final BrowserManager browserManager;
    private final WebSocketServer webSocketServer;

    public ServerService(ServerConfig config, BrowserManager browserManager, WebSocketServer webSocketServer) {
        this.config = config;
        this.browserManager = browserManager;
        this.webSocketServer = webSocketServer;
    }

    public void updateConfig(ServerConfig config) {
        this.config.update(config);
    }

    public void startBrowserTracker() {
        webSocketServer.start(config.getPort());
        browserManager.startBrowserTracker();
    }

    public void stopBrowserTracker() {
        browserManager.stopBrowserTracker();
        webSocketServer.stop();
    }
}