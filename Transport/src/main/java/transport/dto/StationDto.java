package transport.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import transport.dto.StationDto;
import transport.enums.StationName;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StationDto {

	

	private Long id;
	private StationName station;
	
	
}
