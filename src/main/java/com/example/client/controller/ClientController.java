package com.example.client.controller;




import com.example.client.service.ClientService;
import com.example.common.MouseCoordinate;
import com.example.config.ClientConfig;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

//    @GetMapping("/config")
//    public ClientConfig getConfig() {
//        return clientService.getConfig();
//    }

    @PostMapping("/config")
    public void updateConfig(@RequestBody ClientConfig config) {
        clientService.updateConfig(config);
    }

    @GetMapping("/start")
    public void startMouseTracker() {
        clientService.startMouseTracker();
    }

    @GetMapping("/stop")
    public void stopMouseTracker() {
        clientService.stopMouseTracker();
    }

    @GetMapping("/log")
    public List<MouseCoordinate> getLog(@RequestParam("sortBy") String sortBy) {
        return clientService.getLog(sortBy);
    }
}