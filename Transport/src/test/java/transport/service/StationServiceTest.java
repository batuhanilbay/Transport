package transport.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import java.util.ArrayList;
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
import transport.entity.Station;
import transport.enums.StationName;
import transport.repository.StationRepository;
import transport.service.concretes.StationServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class StationServiceTest {

	private Station station;
	private StationName stationName;
	private List<Station> stationList;
	private StationDto stationDto;
	
	@Mock
	private ModelMapper modelMapper;
	@Mock
	private StationRepository stationRepository;
	@Mock
	private StationServiceTest stationServiceTest;
	@InjectMocks
	private StationServiceImpl stationService;
	
	
	@BeforeEach
	public void setup() {
		station = new Station();
		station.setId(1L);
		station.setStation(StationName.A1);
		stationList = new ArrayList<>();
		stationDto = modelMapper.map(station, StationDto.class);
		stationList.add(station);
		
	}
	
	
	@Test()
	@DisplayName("Get ALL STATIONS Unit Test")
	public void get_all_advert_test() {
		Mockito
		.when(stationRepository.findAll())
		.thenReturn(stationList);
		
		List<StationDto> getStationsTest = stationService.getAllStations();
		assertNotNull(getStationsTest);

		assertThat(getStationsTest.size()).isNotZero();
		
	}
	
	@Test()
	@DisplayName("Testing with the Station-Save")
	public void save_station_test() {
		
		StationDto stationDto = prepareStationDto();

	
		Mockito
		.when(stationRepository.findById(stationDto.getId()));
		
		Mockito
		.when(stationRepository.save(any()))
		.thenReturn(stationDto);
	

		stationDto = stationService.saveStation(stationDto);
		assertEquals(StationName.A3, stationDto.getStation());
		assertEquals(5L, stationDto.getId());
		
	}

	
	private StationDto prepareStationDto() {
		StationDto request = new StationDto();
		request.setId(5L);
		request.setStation(StationName.A3);
		return request;
	}
	

	
}
