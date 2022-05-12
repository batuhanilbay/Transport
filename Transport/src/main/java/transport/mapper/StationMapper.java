package transport.mapper;

import transport.dto.StationDto;
import transport.entity.Station;

public class StationMapper {

	
	public static Station dtoToEntity(StationDto stationDto) {
		
		return Station.builder()
				.id(stationDto.getId())
				.station(stationDto.getStation())
				.build();
		
	}
	
	public static StationDto entityToDto(Station station) {
		
		return StationDto.builder()
				.id(station.getId())
				.station(station.getStation())
				.build();
		
	}
	
	
}
