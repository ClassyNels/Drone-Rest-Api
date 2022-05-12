package com.drones.drone.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BatteryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String serial_number;
    private Double battery_capacity;

    public BatteryModel() {
    }

    public BatteryModel(String serial_number, Double battery_capacity) {
        this.serial_number = serial_number;
        this.battery_capacity = battery_capacity;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public Double getBattery_capacity() {
        return battery_capacity;
    }

    public void setBattery_capacity(Double battery_capacity) {
        this.battery_capacity = battery_capacity;
    }
}
