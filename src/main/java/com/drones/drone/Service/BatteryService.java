package com.drones.drone.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class BatteryService {
    @Autowired
    DroneService droneService;


    @Scheduled(cron = "5 * * * * ?")
    public void scheduleTaskUsingCronExpression() {
        droneService.getAll();
        long now = System.currentTimeMillis() / 1000;
        System.out.println(
                "schedule tasks using cron jobs - " + now);
    }
}
