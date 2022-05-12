package transport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import transport.enums.StationName;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Station")
@Table(name = "stations")
public class Station {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "station_id", unique = true, nullable = false)
	private Long id;
	@Enumerated(EnumType.STRING)
	private StationName station;

	
	
}
