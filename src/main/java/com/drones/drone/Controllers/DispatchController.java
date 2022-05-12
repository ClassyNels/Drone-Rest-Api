package com.drones.drone.Controllers;

import com.drones.drone.Models.DispatchModel;
import com.drones.drone.Models.DispatchResponse;
import com.drones.drone.Models.MedicineModel;
import com.drones.drone.Models.drone;
import com.drones.drone.Repository.DispatchRepository;
import com.drones.drone.Repository.DispatchResponseRepository;
import com.drones.drone.Repository.MedicineRepository;
import com.drones.drone.Repository.droneRepository;
import com.drones.drone.Service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/dispatch")
public class DispatchController {
    @Autowired
    DispatchRepository dispatchRepository;

    @Autowired
    DispatchResponseRepository dispatchResponseRepository;
    @Autowired
    droneRepository DroneRepository;
    @Autowired
    MedicineRepository medicineRepository;
    @Autowired
    DispatchService dispatchService;
    @PostMapping("/createload")
    public ResponseEntity<DispatchModel> checkload(@RequestBody DispatchModel dispatchModel)
        {
            return dispatchService.load(dispatchModel);

        }
    @PostMapping("/load")
    public ResponseEntity<DispatchResponse> load(@RequestBody DispatchModel dispatchModel)
       {
           drone _drone = DroneRepository.findidle(dispatchModel.getSerial_number());
           MedicineModel _medicineModel = medicineRepository.findcode(dispatchModel.getMedicine_code());
           DispatchResponse _dispatchResponsed;
           if(_drone == null){
               System.out.println("no data in drone table");
               return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
           }
           if(_medicineModel == null){
               System.out.println("no data in medicine table");
               return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
           }
           if(Integer.parseInt(_medicineModel.getMedicine_weight()) > _drone.getModel_capacity()){
               System.out.println("weight greater than drone capacity not ok for loading");
               return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
           }
           if(_drone.getBattery_capacity() > 0.26 && Objects.equals(_drone.getState_status(), "IDLE") && Integer.parseInt(_medicineModel.getMedicine_weight()) < _drone.getModel_capacity()){
               dispatchService.load(dispatchModel);
               _drone.setState_status("LOADING");
               DroneRepository.save(_drone);
               _dispatchResponsed =new DispatchResponse(
                       _drone.getSerial_number(),
                       _drone.getModel_capacity(),
                       _drone.getWeight_capacity(),
                       _drone.getBattery_capacity(),
                       _medicineModel.getMedicine_name(),
                       _medicineModel.getMedicine_weight(),
                       _medicineModel.getMedicine_code(),
                       dispatchModel.getSource(),
                       dispatchModel.getDestination(),
                       dispatchModel.getStatus()
               );
               DispatchResponse _dispatchResponse = dispatchResponseRepository.save(_dispatchResponsed);
               System.out.println("Battery_capacity"+ _drone.getBattery_capacity() + "state_status"+ _drone.getState_status());
           }else{
               System.out.println("not idle or less than 25");
               return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
           }
           return new ResponseEntity<>(_dispatchResponsed, HttpStatus.OK);
//        return _medicineModel;
       // return dispatchService.load(dispatchModel);
    }
    @PostMapping("/viewLoaded")
    public List<DispatchResponse> getData(@RequestParam String serial_number)
    {
        System.out.println("serialno:"+ serial_number);
//        String serial_numberw = "XEQDPPPFTO";
        List<DispatchResponse> dispatchResponses = dispatchResponseRepository.findLoadedData(serial_number);
        System.out.println("response is:"+ dispatchResponses);
        return dispatchResponses;
    }

    @PostMapping("/viewLoadeddata")
    public List<DispatchResponse> getLoadedData(@RequestBody DispatchResponse dispatchResponse)
    {
        String serial_number = dispatchResponse.getSerial_number();
        System.out.println("serialno:"+ serial_number);
//        String serial_numberw = "XEQDPPPFTO";
        List<DispatchResponse> dispatchResponses = dispatchResponseRepository.findLoadedData(serial_number);
        System.out.println("response is:"+ dispatchResponses);
        return dispatchResponses;
    }
}
