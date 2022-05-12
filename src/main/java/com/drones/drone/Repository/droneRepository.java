package com.drones.drone.Repository;

import com.drones.drone.Models.drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface droneRepository extends JpaRepository<drone, Long> {

    @Query("SELECT t FROM drone t WHERE t.state_status = 'IDLE'")
    List<drone> findAvailable();

    @Query("SELECT t FROM drone t")
    List<drone> findAll();

    @Query("SELECT t FROM drone t WHERE t.serial_number = ?1")
    drone findidle(String name);
}
