package com.drones.drone.Controllers;

import com.drones.drone.Models.BatteryModel;
import com.drones.drone.Models.drone;
import com.drones.drone.Repository.droneRepository;
import com.drones.drone.Service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drone")
public class DroneController {
    @Autowired
    droneRepository DroneRepository;
    @Autowired
    DroneService droneService;

    @PostMapping("/hello")
    public String Register() {
        return "Hello ";
    }

    @PostMapping("/register")
    public ResponseEntity<drone> createDrone(@RequestBody drone Drone) {
        return droneService.register(Drone);
    }

    @PostMapping("/available")
    public List<drone> available() {
        List<drone> _drone = DroneRepository.findAvailable();
        return _drone;
    }

    @PostMapping("/givendrone")
    public BatteryModel givendrone(@RequestParam("serial_number") String serial_number) {
        drone _drone = DroneRepository.findidle(serial_number);
        BatteryModel _batteryModel = new BatteryModel(_drone.getSerial_number(),_drone.getBattery_capacity());
//        Double battery = _drone.getBattery_capacity();
        return _batteryModel;
    }

    @PostMapping("/postbody")
    public String postBody(@RequestBody String fullName) {
        return "Hello " + fullName;
    }
}
