package transport.mapper;

import java.util.Date;

import lombok.Builder;
import transport.dto.VehicleDto;
import transport.entity.Vehicle;
import transport.mapper.VehicleMapper;

@Builder
public class VehicleMapper {

	public static Vehicle dtoToEntity(VehicleDto vehicleDto) {
		
		
		Date nowDate = new Date();

		return Vehicle.builder()
			.id(vehicleDto.getId())
			.vehicleType(vehicleDto.getVehicleType())
			.registerTime(nowDate)
			.departureDay(vehicleDto.getDepartureDay())
			.departureHour(vehicleDto.getDepartureHour())
			.day(vehicleDto.getDay())
			.departureStationId(vehicleDto.getDepartureStationId())
			.arrivalStationId(vehicleDto.getArrivalStationId())
			.build();	

	}

	public static VehicleDto entityToDto(Vehicle vehicle) {
		
		Date nowDate = new Date();
		
	
		return VehicleDto.builder()
			.id(vehicle.getId())
			.vehicleType(vehicle.getVehicleType())
			.day(vehicle.getDay())
			.departureStationId(vehicle.getDepartureStationId())
			.arrivalStationId(vehicle.getArrivalStationId())
			.registerTime(nowDate)
			.departureDay(vehicle.getDepartureDay())
			.departureHour(vehicle.getDepartureHour())
			.build();
	
	}
	
	
}
