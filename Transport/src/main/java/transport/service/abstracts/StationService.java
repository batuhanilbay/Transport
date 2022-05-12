package transport.service.abstracts;

import java.util.List;

import transport.dto.StationDto;

public interface StationService {

	StationDto saveStation(StationDto stationDto);
	List<StationDto> getAllStations();
	StationDto getStationById(Long stationId);
	void deleteStationById(Long stationId);
	StationDto updateStation(Long stationId,StationDto stationDto);
	
	
}
