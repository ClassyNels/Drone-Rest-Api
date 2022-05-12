package com.drones.drone.Models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class AuditTrails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String serial_number;
    private double battery_capacity;
    @CreationTimestamp
    private LocalDateTime createdDateTime;

    public AuditTrails() {
    }

    public AuditTrails(String serial_number, double battery_capacity, LocalDateTime createdDateTime) {
        this.serial_number = serial_number;
        this.battery_capacity = battery_capacity;
        this.createdDateTime = createdDateTime;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public double getBattery_capacity() {
        return battery_capacity;
    }

    public void setBattery_capacity(double battery_capacity) {
        this.battery_capacity = battery_capacity;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}
