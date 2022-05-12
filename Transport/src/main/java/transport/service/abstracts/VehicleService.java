package transport.service.abstracts;

import java.util.List;

import transport.dto.VehicleDto;

public interface VehicleService {

	 VehicleDto saveVehicle(VehicleDto vehicleDto);
	 List<VehicleDto> getAllVehicle();
	 VehicleDto getVehicleById(Long vehicleId);
	 void deleteVehicle(Long vehicleId);
	 VehicleDto updateVehicle(Long vehicleId,VehicleDto vehicleDto);
	
	
	
}
