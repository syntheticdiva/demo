package com.example.server.controller;

import com.example.config.ServerConfig;
import com.example.server.service.ServerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/server")
public class ServerController {
    private final ServerService serverService;

    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @GetMapping("/config")
    public ServerConfig getConfig() {
        return serverService.getConfig();
    }

    @PostMapping("/config")
    public void updateConfig(@RequestBody ServerConfig config) {
        serverService.updateConfig(config);
    }

    @GetMapping("/start")
    public void startBrowserTracker() {
        serverService.startBrowserTracker();
    }

    @GetMapping("/stop")
    public void stopBrowserTracker() {
        serverService.stopBrowserTracker();
    }
}