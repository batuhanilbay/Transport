package transport.mapper;

import transport.dto.LoginDto;
import transport.entity.User;

public class UserMapper {

	public static User dtoToEntity(LoginDto userDto) {
		
		
		return User.builder()
			.id(userDto.getId())
			.email(userDto.getEmail())
			
			.build();	

}

public static LoginDto entityToDto(User user) {
	
	
		return LoginDto.builder()
			.id(user.getId())
			.email(user.getEmail())
			.build();
	
}
	
	
}
