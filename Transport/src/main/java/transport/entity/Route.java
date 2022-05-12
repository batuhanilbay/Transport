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
import transport.entity.Route;
import transport.enums.StationName;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Route")
@Table(name = "routes")
public class Route {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "route_id", unique = true, nullable = false)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private StationName departure;
	@Enumerated(EnumType.STRING)
	private StationName arrival;
	
}
