package transport.service.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import transport.dto.LoginDto;
import transport.entity.User;
import transport.repository.UserRepository;
import transport.service.abstracts.UserService;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired(required = true)
	private ModelMapper modelMapper;
	


	@Override
	public List<LoginDto> getAllUsers() {
		List<User> users = userRepository.findAll();
        log.info("All Users listed.");
		return users.stream().map(usr -> modelMapper.map(usr, LoginDto.class)).collect(Collectors.toList());
	}

	@Override
	public LoginDto getUserById(Long userId) {
		Optional<User> isUser = userRepository.findById(userId);	
		return isUser.map(usr->modelMapper.map(usr, LoginDto.class)).orElse(null);
	}

	@Override
	public void deleteUser(Long userId) {
		getUserById(userId);
		userRepository.deleteById(userId);	
	}

	@Override
	public LoginDto updateUser(Long userId, LoginDto userDto) {
		User user = modelMapper.map(userDto, User.class);;
		user.setEmail(userDto.getEmail());
	
		return modelMapper.map(userRepository.save(user),LoginDto.class);	
	
	}
	

	
}
