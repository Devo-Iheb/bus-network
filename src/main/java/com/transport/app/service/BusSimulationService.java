package com.transport.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transport.app.websocket.BusWebSocketHandler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Random;

@Service
public class BusSimulationService {
    private final BusWebSocketHandler busWebSocketHandler;
    private final Random random = new Random();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public BusSimulationService(BusWebSocketHandler busWebSocketHandler) {
        this.busWebSocketHandler = busWebSocketHandler;
    }

    @Scheduled(fixedRate = 3000) // Toutes les 3 secondes
    public void sendBusUpdates() throws IOException {
        BusData busData = new BusData(
            random.nextInt(5) + 1,
            "Route " + (random.nextInt(3) + 1),
            48.85 + random.nextDouble() * 0.02 - 0.01,
            2.35 + random.nextDouble() * 0.02 - 0.01
        );
        String message = objectMapper.writeValueAsString(busData);
        busWebSocketHandler.broadcastBusUpdate(message);
    }

    private record BusData(int id, String route, double latitude, double longitude) {}
}
