package transport.service.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import transport.service.abstracts.StationService;
import transport.dto.StationDto;
import transport.entity.Station;
import transport.repository.StationRepository;
import transport.service.concretes.StationServiceImpl;

@Service
@Slf4j
public class StationServiceImpl implements StationService {

	@Autowired
	private StationRepository stationRepository;
	@Autowired(required = true)
	private ModelMapper modelMapper;
	

	@Override
	public StationDto saveStation(StationDto stationDto) {
		Station station = modelMapper.map(stationDto,Station.class);
		log.info(station + "Add MYSQL DB");
		return modelMapper.map(stationRepository.save(station),StationDto.class);
		
	}

	@Override
	public List<StationDto> getAllStations() {
		List<Station> stations = stationRepository.findAll();
        log.info("All Stations listed.");
		return stations.stream().map(st -> modelMapper.map(st, StationDto.class)).collect(Collectors.toList());
	}

	@Override
	public StationDto getStationById(Long stationId) {
		Optional<Station> isStation = stationRepository.findById(stationId);
		return isStation.map(st->modelMapper.map(st,StationDto.class)).orElse(null);
	}

	@Override
	public void deleteStationById(Long stationId) {
		getStationById(stationId);
		stationRepository.deleteById(stationId);
		
	}

	@Override
	public StationDto updateStation(Long stationId, StationDto stationDto) {
		Station station = modelMapper.map(stationDto,Station.class);
		station.setStation(stationDto.getStation());
		//station.setVehicles(stationDto.getVehicles());
		return modelMapper.map(stationRepository.save(station),StationDto.class);
	}
	
	
}
