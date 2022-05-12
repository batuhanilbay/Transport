package transport.entity;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import transport.entity.Vehicle;
import transport.enums.TimeTable;
import transport.enums.VehicleType;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Vehicle")
@Table(name = "vehicles")
public class Vehicle {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_id", unique = true, nullable = false)
	private Long id;
	@Enumerated(EnumType.STRING)
	@NotNull
	private VehicleType vehicleType;
	@Enumerated(EnumType.STRING)
	@NotNull
	private TimeTable day;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "Asia/Turkey")
	private Date registerTime = new Date();
	private Calendar  departureDay = Calendar.getInstance();
	private Calendar  departureHour = Calendar.getInstance();
	private Long departureStationId;
	private Long arrivalStationId;
	
	
}
