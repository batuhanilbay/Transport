package transport.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import transport.dto.LoginDto;
import transport.service.abstracts.UserService;

@RestController
public class UserController {

	private UserService userService;
	
	@Autowired(required = true)
	public UserController(UserService userService) {
		this.userService = userService;
	}

	
	@GetMapping(value = "/users")
	public ResponseEntity<List<LoginDto>> getAllUsers(){
		return ResponseEntity.ok().body(userService.getAllUsers());
	}
	
	@GetMapping(value = "/users/{userId}")
	public ResponseEntity<LoginDto> getUserById(@PathVariable Long userId){
		LoginDto userDto = userService.getUserById(userId);
		return ResponseEntity.ok().body(userService.getUserById(userDto.getId()));
	}
	
	@DeleteMapping(value = "/users/{userId}")
	public ResponseEntity<?> deleteUserById(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>("The User " + userId + " has been deleted...",HttpStatus.OK);
	}
	
	
	
}
