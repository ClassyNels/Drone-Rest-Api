package com.drones.drone.Repository;

import com.drones.drone.Models.DispatchResponse;
import com.drones.drone.Models.drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DispatchResponseRepository extends JpaRepository<DispatchResponse, Long> {

    @Query("SELECT t FROM DispatchResponse t WHERE t.serial_number = ?1")
    List<DispatchResponse> findLoadedData(String name);

    @Query("SELECT t FROM DispatchResponse t WHERE t.serial_number = ?1")
    DispatchResponse findLoaded(String name);
}
