package com.drones.drone.Service;

import com.drones.drone.Models.DispatchModel;
import com.drones.drone.Repository.DispatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;

@Service
public class DispatchService {
    @Autowired
    DispatchRepository dispatchRepository;

    public ResponseEntity<DispatchModel> load(DispatchModel dispatchModel)
    {
        try
        {
            DispatchModel _dispatchModel = dispatchRepository
                    .save(new DispatchModel(dispatchModel.getSerial_number(),dispatchModel.getMedicine_code(),
                            dispatchModel.getSource(),dispatchModel.getDestination(),dispatchModel.getStatus()));
            return new ResponseEntity<>(_dispatchModel, HttpStatus.CREATED);
        }catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
