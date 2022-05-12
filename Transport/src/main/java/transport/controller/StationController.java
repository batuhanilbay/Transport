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

import transport.dto.StationDto;
import transport.service.abstracts.StationService;

@RestController
public class StationController {
	
	@Autowired
	StationService stationService;
	
	@GetMapping(value = "/stations")
	public ResponseEntity<List<StationDto>> getAllStations(){
		return ResponseEntity.ok().body(stationService.getAllStations());
	}
	
	@GetMapping(value = "/stations/{stationId}")
	public ResponseEntity<StationDto> getStationById(@PathVariable Long stationId){
		StationDto stationDto = stationService.getStationById(stationId);
		return ResponseEntity.ok().body(stationService.getStationById(stationDto.getId()));

	}
	
	@PutMapping(value = "/update/stations/{stationId}")
	public ResponseEntity<StationDto> updateStation(@PathVariable Long stationId,@RequestBody StationDto stationDto) {
	   
		return new ResponseEntity<>(stationService.updateStation(stationId, stationDto), HttpStatus.OK);
	
	}
	
	@PostMapping(value = "/stations")
	public ResponseEntity<StationDto> addStation(@RequestBody StationDto stationDto){
		 StationDto createStation = stationService.saveStation(stationDto);
		return new ResponseEntity<>(createStation,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/stations/{stationId}")
	public ResponseEntity<?> deleteUserById(@PathVariable Long stationId) {
		stationService.deleteStationById(stationId);
		return new ResponseEntity<>("The Station " + stationId + " has been deleted...",HttpStatus.OK);
	}

}
