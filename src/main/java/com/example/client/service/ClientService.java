package com.example.client.service;


import com.example.client.repository.ClientRepository;
import com.example.common.MouseCoordinate;
import com.example.config.ClientConfig;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Getter
    private final ClientConfig config;
    private final ClientRepository clientRepository;
    private final WebSocketClient webSocketClient;

    public ClientService(ClientConfig config, ClientRepository clientRepository, WebSocketClient webSocketClient) {
        this.config = config;
        this.clientRepository = clientRepository;
        this.webSocketClient = webSocketClient;
    }

    public void updateConfig(ClientConfig newConfig) {
        config.update(newConfig);
    }

    public void startMouseTracker() {
        webSocketClient.connect(config.getServerIp(), config.getServerPort());
        webSocketClient.startMouseTracker();
    }

    public void stopMouseTracker() {
        webSocketClient.stopMouseTracker();
    }

    public List<MouseCoordinate> getLog(String sortBy) {
        return clientRepository.getLogSortedBy(sortBy);
    }

}
//@Service
//public class ClientService {
//    @Getter
//    private final ClientConfig config;
//    private final ClientRepository clientRepository;
//    private final WebSocketClient webSocketClient;
//
//    public ClientService(ClientConfig config, ClientRepository clientRepository, WebSocketClient webSocketClient) {
//        this.config = config;
//        this.clientRepository = clientRepository;
//        this.webSocketClient = webSocketClient;
//    }
//
//    public void updateConfig(ClientConfig config) {
//        this.config.update(config);
//    }
//
//    public void startMouseTracker() {
//        webSocketClient.connect(config.getServerIp(), config.getServerPort());
//        webSocketClient.startMouseTracker();
//    }
//
//    public void stopMouseTracker() {
//        webSocketClient.stopMouseTracker();
//    }
//
//    public List<MouseCoordinate> getLog(String sortBy) {
//        return clientRepository.getLogSortedBy(sortBy);
//    }
//}