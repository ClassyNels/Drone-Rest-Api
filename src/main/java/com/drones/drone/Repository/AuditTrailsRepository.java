package com.drones.drone.Repository;

import com.drones.drone.Models.AuditTrails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditTrailsRepository extends JpaRepository<AuditTrails, Long> {
}
