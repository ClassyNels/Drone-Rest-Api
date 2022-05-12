package com.drones.drone.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
public class drone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Size(min = 4, max = 100, message ="minimum of 4 and maximum of 100")
    private String serial_number;
    private int model_capacity;
//    @Max(v)
    private String weight_capacity;
    private double battery_capacity;
    private String state_status;

    public drone() {
    }

    public drone(String serial_number, int model_capacity, String weight_capacity, double battery_capacity, String state_status) {
        this.serial_number = serial_number;
        this.model_capacity = model_capacity;
        this.weight_capacity = weight_capacity;
        this.battery_capacity = battery_capacity;
        this.state_status = state_status;
    }

    public drone(Long id, String serial_number, int model_capacity, String weight_capacity, double battery_capacity, String state_status) {
        this.id = id;
        this.serial_number = serial_number;
        this.model_capacity = model_capacity;
        this.weight_capacity = weight_capacity;
        this.battery_capacity = battery_capacity;
        this.state_status = state_status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public int getModel_capacity() {
        return model_capacity;
    }

    public void setModel_capacity(int model_capacity) {
        this.model_capacity = model_capacity;
    }

    public String getWeight_capacity() {
        return weight_capacity;
    }

    public void setWeight_capacity(String weight_capacity) {
        this.weight_capacity = weight_capacity;
    }

    public double getBattery_capacity() {
        return battery_capacity;
    }

    public void setBattery_capacity(double battery_capacity) {
        this.battery_capacity = battery_capacity;
    }

    public String getState_status() {
        return state_status;
    }

    public void setState_status(String state_status) {
        this.state_status = state_status;
    }
}
