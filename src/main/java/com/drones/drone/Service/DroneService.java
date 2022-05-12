package com.drones.drone.Service;

import com.drones.drone.Models.AuditTrails;
import com.drones.drone.Models.drone;
import com.drones.drone.Repository.AuditTrailsRepository;
import com.drones.drone.Repository.droneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DroneService {
    @Autowired
    droneRepository DroneRepository;

    @Autowired
    AuditTrailsRepository auditTrailsRepository;

    public ResponseEntity<drone> register(drone Drone){
        try {
            drone _drone = DroneRepository
                    .save(new drone(Drone.getSerial_number(), Drone.getModel_capacity(), Drone.getWeight_capacity(),
                            Drone.getBattery_capacity(), Drone.getState_status()));
            return new ResponseEntity<>(_drone, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void getAll(){
//        public List<AuditTrails> getAll(){
        List<drone> _drone = DroneRepository.findAll();
        List<AuditTrails> _auditTrails  = new ArrayList<>();

        for(drone Drone : _drone) {
            AuditTrails auditTrails = new AuditTrails(
                    Drone.getSerial_number(),
                    Drone.getBattery_capacity(),
                    LocalDateTime.now()
            );
            _auditTrails.add(auditTrails);
        }
        auditTrailsRepository.saveAll(_auditTrails);
//        return _auditTrails;
    }

//    public d
}
