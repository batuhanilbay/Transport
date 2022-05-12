package transport.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import transport.dto.StationDto;
import transport.dto.VehicleDto;
import transport.entity.Vehicle;
import transport.repository.VehicleRepository;
import transport.service.concretes.VehicleServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {

	private Vehicle vehicle;
	private VehicleDto vehicleDto;
	
	private List<Vehicle> vehicleList;
	
	@Mock
	private ModelMapper modelMapper;
	
	@Mock
	private VehicleRepository vehicleRepository;
	
	@InjectMocks
	private VehicleServiceImpl vehicleService;
	Date nowDate = new Date();

	@BeforeEach
	void setup() {
		when(vehicleRepository.findAll())
				.thenReturn(prepareMockVehicleList());
		vehicleDto = modelMapper.map(vehicle, VehicleDto.class);
		when(vehicleService.getAllVehicle())
		.thenReturn(prepareMockVehicleDtoList());
	}
	
	

	@Test()
	public void save_vehicle_test() {
		
		 
		 vehicle = prepareVehicle();
	     doReturn(vehicleDto).when(vehicleRepository).save(vehicle); 
	     vehicleDto = modelMapper.map(vehicle,VehicleDto.class);
	     vehicleService.saveVehicle(vehicleDto);
	     
	     // Assert the Vehicle response 
	     Assertions.assertNotNull(vehicleDto, "The saved Vehicle should not be null");
		
	}
	
	@Test
	void getAllVehicles() {
		vehicleList = vehicleRepository.findAll();
        assertThat(vehicleList.size()).isNotZero();
		
	}
	
	
	private List<Vehicle> prepareMockVehicleList(){
		List<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(prepareVehicle());
		return vehicles;	
	}
	
	private List<VehicleDto> prepareMockVehicleDtoList(){
		List<VehicleDto> vehicles = new ArrayList<>();
		vehicles.add(prepareVehicleDto());
		return vehicles;	
	}
	
	private Vehicle prepareVehicle() {
	
	vehicle = new Vehicle();
	vehicle.setId(2L);
	vehicle.setRegisterTime(nowDate);	
	vehicle.setArrivalStationId(1L);
	
	return vehicle;
	}
	
	
	private VehicleDto prepareVehicleDto() {
		
	Date nowDate = new Date();
	vehicleDto = new VehicleDto();
	vehicleDto.setId(2L);
	vehicleDto.setRegisterTime(nowDate);	
	vehicleDto.setArrivalStationId(1L);
	
	return vehicleDto;
	}
	
	
	

}
