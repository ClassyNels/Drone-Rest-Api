package com.drones.drone.Controllers;

import com.drones.drone.Models.MedicineModel;
import com.drones.drone.Repository.MedicineRepository;
import com.drones.drone.Service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;

@RestController
@RequestMapping("medicine")
public class MedicineController {
    @Autowired
    MedicineRepository medicineRepository;
    @Autowired
    MedicineService medicineService;

    @PostMapping("/register")
    public ResponseEntity<MedicineModel> registerDrone(@RequestBody MedicineModel medicineModel) {
        return medicineService.register(medicineModel);
    }

    @PostMapping(value ="/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MedicineModel> createDrone(@Valid @RequestPart MedicineModel medicineModel, @RequestParam("file") MultipartFile file)
    {
        String response = medicineService.uploadFile(file);
        System.out.println("returned value is"+ response);
        return medicineService.create(medicineModel,response);
    }
    // Upload image to local folder
    @RequestMapping(value = "/upload/local", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadedFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileLocation = new File("src\\main\\resources\\static\\uploads").getAbsolutePath() + "\\" + file.getOriginalFilename();
            System.out.println("fileLocation" + fileLocation);
                        File path = new File(fileLocation);
                        System.out.println("path" + path);
            path.createNewFile();
            FileOutputStream output = new FileOutputStream(path);
            output.write(file.getBytes());
            output.close();
            return new ResponseEntity<>(path, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.MULTI_STATUS);
       }
    }
}
