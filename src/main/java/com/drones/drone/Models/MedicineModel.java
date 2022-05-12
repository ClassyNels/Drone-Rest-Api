package com.drones.drone.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class MedicineModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Pattern(regexp="^[a-zA-Z0-9-_]+$",message="allowed only letters, numbers, ‘-‘, ‘_’")
    private String medicine_name;
    private String medicine_weight;
    @Pattern(regexp="^[A-Z0-9_]+$",message="allowed only upper case letters, underscore and numbers")
    private String medicine_code;
    private String medicine_image;

    public MedicineModel() {
    }

    public MedicineModel(String medicine_name, String medicine_weight, String medicine_code) {
        this.medicine_name = medicine_name;
        this.medicine_weight = medicine_weight;
        this.medicine_code = medicine_code;
    }

    public MedicineModel(String medicine_name, String medicine_weight, String medicine_code, String medicine_image) {
        this.medicine_name = medicine_name;
        this.medicine_weight = medicine_weight;
        this.medicine_code = medicine_code;
        this.medicine_image = medicine_image;
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

    public String getMedicine_image() {
        return medicine_image;
    }

    public void setMedicine_image(String medicine_image) {
        this.medicine_image = medicine_image;
    }

    //    private String medicine_name;
}
