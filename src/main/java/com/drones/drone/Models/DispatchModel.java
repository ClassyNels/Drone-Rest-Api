package com.drones.drone.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DispatchModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String serial_number;
    private String medicine_code;
    private String source;
    private String destination;
    private String status;

    public DispatchModel() {
    }

    public DispatchModel(String serial_number, String medicine_code, String source, String destination, String status) {
        this.serial_number = serial_number;
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
