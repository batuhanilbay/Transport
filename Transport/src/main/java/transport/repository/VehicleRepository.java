package transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import transport.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

}
