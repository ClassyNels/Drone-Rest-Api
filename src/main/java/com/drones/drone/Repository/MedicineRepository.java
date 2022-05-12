package com.drones.drone.Repository;

import com.drones.drone.Models.MedicineModel;
import com.drones.drone.Models.drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicineRepository extends JpaRepository<MedicineModel, Long> {

    @Query("SELECT t FROM MedicineModel t WHERE t.medicine_code = ?1")
    MedicineModel findcode(String name);
}
