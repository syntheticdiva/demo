package com.example.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "client")
@Getter
@Setter
public class ClientConfig {
    @Value("${client.server-ip}")
    private String serverIp;
    @Value("${client.server-port}")
    private int serverPort;
    @Value("${client.frequency}")
    private int frequency;

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public ClientConfig(String serverIp, int serverPort, int frequency) {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.frequency = frequency;
    }
        public void update(ClientConfig newConfig) {
        this.serverIp = newConfig.getServerIp();
        this.serverPort = newConfig.getServerPort();
    }

}