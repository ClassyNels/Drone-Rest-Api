package com.drones.drone.Service;

import com.drones.drone.Models.MedicineModel;
import com.drones.drone.Repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@Service
public class MedicineService {
@Autowired
MedicineRepository medicineRepository;
    public ResponseEntity<MedicineModel> register(MedicineModel medicineModel){
        try {
            MedicineModel _medicineModel = medicineRepository
                    .save(new MedicineModel(medicineModel.getMedicine_name(), medicineModel.getMedicine_weight(),
                            medicineModel.getMedicine_code()
                            ));
            return new ResponseEntity<>(_medicineModel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public String uploadFile(MultipartFile file) {
//        public ResponseEntity<Object> uploadFile(MultipartFile file) {
        try {
            String fileLocation = new File("src\\main\\resources\\static\\uploads").getAbsolutePath() + "\\" + file.getOriginalFilename();
//            System.out.println("fileLocation" + fileLocation);
            File path = new File(fileLocation);
//            System.out.println("path" + path); path.createNewFile();
            FileOutputStream output = new FileOutputStream(path);
            output.write(file.getBytes());
            output.close();
            return path.toString();
//            return new ResponseEntity<>(path, HttpStatus.OK);
           } catch (Exception e) {
            return null;
//            return new ResponseEntity<>(null, HttpStatus.MULTI_STATUS);
           }
    }
    public ResponseEntity<MedicineModel> create(MedicineModel medicineModel, String path){
        try {
            MedicineModel _medicineModel = medicineRepository
                    .save(new MedicineModel(medicineModel.getMedicine_name(), medicineModel.getMedicine_weight(),
                            medicineModel.getMedicine_code(), path
                    ));
            return new ResponseEntity<>(_medicineModel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
