package transport.service.concretes;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import transport.dto.VehicleDto;
import transport.enums.VehicleType;
import transport.exception.InvalidStation;
import transport.entity.Station;
import transport.entity.Vehicle;
import transport.repository.StationRepository;
import transport.repository.VehicleRepository;
import transport.service.abstracts.VehicleService;
import transport.service.concretes.VehicleServiceImpl;

@Service
@Slf4j
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private StationRepository stationRepository;
	@Autowired(required = true)
	private ModelMapper modelMapper;

	
	@Override
	public VehicleDto saveVehicle(VehicleDto vehicleDto) {
		Optional<Station> departureStation = stationRepository.findById(vehicleDto.getDepartureStationId());
		Optional<Station> arrivalStation = stationRepository.findById(vehicleDto.getArrivalStationId());
		
		//Türkiye saati ayarlamasý.
		Date nowDate = new Date(vehicleDto.getRegisterTime().getTime() + (1000L*60*60*3));
		vehicleDto.setRegisterTime(nowDate);
		vehicleDto.setDepartureStationId(departureStation.get().getId());
		vehicleDto.setArrivalStationId(arrivalStation.get().getId());
		
		String pattern = "EEEEE dd MMMMM yyyy HH:mm:ss.SSSZ";
        String dayNames[] = new DateFormatSymbols().getWeekdays();

		Locale locale = new Locale("tr","TR");
		Calendar departureDate = Calendar.getInstance();
		Calendar departureHour = Calendar.getInstance();
		vehicleDto.setDepartureDay(departureDate);
		vehicleDto.setDepartureHour(departureHour);
		
		//Kalkýþ ve varýþ istasyonlarý ayný olamaz. 
		
		
		if(vehicleDto.getDepartureStationId() != vehicleDto.getArrivalStationId()) {
			Vehicle vehicle = modelMapper.map(vehicleDto, Vehicle.class);
			log.info(vehicle + "Add MYSQL DB");
			//Burada daha farklý business logicler uygulanabilirdi. :) 
			//1 hafta sonraya kalkýþ tarihi ayarlanýr.
			//Otobüs ise sabah 7.00 saatine
			if(vehicleDto.getVehicleType() == VehicleType.BUS) {
				departureDate.add(Calendar.DATE, 7);
				vehicleDto.setDepartureDay(departureDate);
				departureHour.set(Calendar.HOUR_OF_DAY,Calendar.MONTH,Calendar.DATE,7,0,0);
				vehicleDto.setDepartureHour(departureHour);		

			}
			
			//Yine 1 hafta sonraya ayarlanýr. 
			//Tramvay için sabah saat 8.00 
			else if (vehicleDto.getVehicleType() == VehicleType.TRAM) {
				departureDate.add(Calendar.DATE, 7);
				vehicleDto.setDepartureDay(departureDate);
				departureHour.set(Calendar.HOUR_OF_DAY,Calendar.MONTH,Calendar.DATE,8,0,0);
				vehicleDto.setDepartureHour(departureHour);	

			}
			else if (vehicleDto.getVehicleType() == VehicleType.SUBWAY) {
				departureDate.add(Calendar.DATE, 7);
				vehicleDto.setDepartureDay(departureDate);
				departureHour.set(Calendar.HOUR_OF_DAY,Calendar.MONTH,Calendar.DATE,8,0,0);
				vehicleDto.setDepartureHour(departureHour);	
			}
			
			
			return modelMapper.map(vehicleRepository.save(vehicle),VehicleDto.class);
			
		}
		else {
			log.info("Kalkýþ ve varýþ istasyonlarý ayný olamaz.");
			throw new InvalidStation("The departure and arrival ids cannot be the same.");
			
		}
	
	}

	@Override
	public List<VehicleDto> getAllVehicle() {
		List<Vehicle> vehicles = vehicleRepository.findAll();
        log.info("All Vehicles listed.");
		return vehicles.stream().map(vehiclee -> modelMapper.map(vehiclee, VehicleDto.class)).collect(Collectors.toList());
	}

	@Override
	public VehicleDto getVehicleById(Long vehicleId) {
		Optional<Vehicle> isVehicle = vehicleRepository.findById(vehicleId);	
		return isVehicle.map(vhc->modelMapper.map(vhc, VehicleDto.class)).orElse(null);
	}

	@Override
	public void deleteVehicle(Long vehicleId) {
		getVehicleById(vehicleId);
		vehicleRepository.deleteById(vehicleId);
		
	}

	@Override
	public VehicleDto updateVehicle(Long vehicleId, VehicleDto vehicleDto) {
		Vehicle vehicle = modelMapper.map(vehicleDto, Vehicle.class);;
		vehicle.setVehicleType(vehicleDto.getVehicleType());
		vehicle.setDepartureDay(vehicleDto.getDepartureDay());
		vehicle.setDepartureHour(vehicleDto.getDepartureHour());
		//vehicle.setStations(vehicleDto.getStations());
		return modelMapper.map(vehicleRepository.save(vehicle),VehicleDto.class);	
	
	}
	
	
}
