package com.transport.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.transport.app.websocket.BusWebSocketHandler;

@SpringBootApplication
@EnableWebSocket
public class BusNetworkApplication implements WebSocketConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(BusNetworkApplication.class, args);
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(busWebSocketHandler(), "/bus-tracker").setAllowedOrigins("*");
    }

    // ✅ Ajoute cette méthode pour créer l'instance de BusWebSocketHandler
    @Bean
    public BusWebSocketHandler busWebSocketHandler() {
        return new BusWebSocketHandler();
    }
}
