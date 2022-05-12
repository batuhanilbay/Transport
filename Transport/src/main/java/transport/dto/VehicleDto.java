package transport.dto;

import java.util.Calendar;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import transport.dto.VehicleDto;
import transport.enums.TimeTable;
import transport.enums.VehicleType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class VehicleDto {

	private Long id;
	private VehicleType vehicleType;
	private TimeTable day;
	private Date registerTime = new Date();
	private Calendar departureDay = Calendar.getInstance();
	private Calendar departureHour = Calendar.getInstance();

	private Long departureStationId;
	private Long arrivalStationId;

	
	
}
