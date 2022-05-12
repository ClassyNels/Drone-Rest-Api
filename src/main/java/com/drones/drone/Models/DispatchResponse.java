package com.drones.drone.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DispatchResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String serial_number;
    private int model_capacity;
    private String weight_capacity;
    private double battery_capacity;
    private String medicine_name;
    private String medicine_weight;
    private String medicine_code;
    private String source;
    private String destination;
    private String status;

    public DispatchResponse() {
    }

    public DispatchResponse(String serial_number, int model_capacity, String weight_capacity, double battery_capacity, String medicine_name, String medicine_weight, String medicine_code, String source, String destination, String status) {
        this.serial_number = serial_number;
        this.model_capacity = model_capacity;
        this.weight_capacity = weight_capacity;
        this.battery_capacity = battery_capacity;
        this.medicine_name = medicine_name;
        this.medicine_weight = medicine_weight;
        this.medicine_code = medicine_code;
        this.source = source;
        this.destination = destination;
        this.status = status;
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

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public String getMedicine_weight() {
        return medicine_weight;
    }

    public void setMedicine_weight(String medicine_weight) {
        this.medicine_weight = medicine_weight;
    }

    public String getMedicine_code() {
        return medicine_code;
    }

    public void setMedicine_code(String medicine_code) {
        this.medicine_code = medicine_code;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
