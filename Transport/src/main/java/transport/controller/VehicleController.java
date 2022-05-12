package transport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import transport.dto.VehicleDto;
import transport.service.abstracts.StationService;
import transport.service.abstracts.VehicleService;

@RestController
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	@Autowired
	StationService stationService;
	
	
	@GetMapping(value = "/vehicles")
	public ResponseEntity<List<VehicleDto>> getAllVehicles(){
		return ResponseEntity.ok().body(vehicleService.getAllVehicle());
	}
	
	@GetMapping(value = "/vehicles/{vehicleId}")
	public ResponseEntity<VehicleDto> getUserById(@PathVariable Long vehicleId){
		VehicleDto vehicleDto = vehicleService.getVehicleById(vehicleId);
		return ResponseEntity.ok().body(vehicleService.getVehicleById(vehicleDto.getId()));
	}
	
	@PutMapping(value = "/update/vehicles/{vehicleId}")
	public ResponseEntity<VehicleDto> updateVehicle(@PathVariable Long vehicleId,@RequestBody VehicleDto vehicleDto) {
	   
		return new ResponseEntity<>(vehicleService.updateVehicle(vehicleId, vehicleDto), HttpStatus.OK);
	
	}
	
	@PostMapping(value = "/vehicles")
	public ResponseEntity<VehicleDto> addVehicle(@RequestBody VehicleDto vehicleDto){
		VehicleDto createVehicle = vehicleService.saveVehicle(vehicleDto);
		return new ResponseEntity<>(createVehicle,HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/vehicles/{vehicleId}")
	public ResponseEntity<?> deleteVehicleById(@PathVariable Long vehicleId) {
		vehicleService.deleteVehicle(vehicleId);
		return new ResponseEntity<>("The Vehicle " + vehicleId + " has been deleted...",HttpStatus.OK);
	}
	

}

