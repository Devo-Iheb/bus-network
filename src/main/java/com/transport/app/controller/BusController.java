package com.transport.app.controller;

import com.transport.app.model.Bus;
import com.transport.app.service.BusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/buses")
public class BusController {
    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping
    public List<Bus> getBuses() {
        return busService.getAllBuses();
    }

    @PostMapping
    public Bus addBus(@RequestBody Bus bus) {
        return busService.saveBus(bus);
    }
}
