package transport.service.abstracts;

import java.util.List;
import transport.dto.LoginDto;

public interface UserService {

	


	 List<LoginDto> getAllUsers();
	 LoginDto getUserById(Long userId);
	 void deleteUser(Long userId);
	 LoginDto updateUser(Long userId,LoginDto userDto);
	
}
