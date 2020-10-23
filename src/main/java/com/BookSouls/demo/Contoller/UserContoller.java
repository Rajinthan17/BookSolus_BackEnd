package com.BookSouls.demo.Contoller;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookSouls.Entity.ERole;
import com.BookSouls.Entity.Role;
import com.BookSouls.Entity.User;
import com.BookSouls.Entity.request.SignupRequest;
import com.BookSouls.Entity.resposne.MessageResponse;
import com.BookSouls.demo.Config.BasicAuthUtils;
import com.BookSouls.demo.DAO.RoleRepository;
import com.BookSouls.demo.DAO.UserRepository;
import com.BookSouls.demo.Service.UserService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserContoller {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	BasicAuthUtils basicUtils;
	
	@PostMapping
	public ResponseEntity<?> createUser(@Valid @RequestBody SignupRequest signUpRequest){
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()),
							 signUpRequest.getAddress(),
							 signUpRequest.getPhoneNum(),
							 signUpRequest.getImage());

		Set<String> strRoles = signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.Role_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.Role_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found.."));
					roles.add(adminRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.Role_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found..."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<MessageResponse> updateUser (@PathVariable String id, @RequestBody SignupRequest user ){
		return userService.updateUser(id,user);
	}
	@PutMapping(value = "user/{id}")
	public ResponseEntity<MessageResponse> updateUserByUser (@PathVariable String id, @RequestBody SignupRequest user ){
		return userService.updateUserByUser(id,user);
	}
	
	@PutMapping(value = "password/{id}")
	public ResponseEntity<User>updatePassword(
			@PathVariable String id,
			@RequestParam(name = "oldPassword",defaultValue = "null") String oldPassword,
			@RequestParam(name = "newPassword",defaultValue = "0") String newPassword){
		return userService.updatePassword(id,oldPassword,newPassword);
	}
	
	@PutMapping(value = "forgot/password")
	public ResponseEntity<User>updatePassword(
			@RequestParam(name = "username") String username,
			@RequestParam(name = "newPassword") String newPassword){
		return userService.forgotPasswordUpdate(username,newPassword);
	}
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> getAllUsers(
			@RequestParam(name = "pageNo",defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize",defaultValue = "5") int pageSize){
		return userService.getAllusers(pageNo,pageSize);
	}
	
	@GetMapping(value = "/Searchedpage")
	public ResponseEntity<Map<String, Object>> getSearchUsers(
			@RequestParam(name = "searched",defaultValue = "0") String searched,
			@RequestParam(name = "pageNo",defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize",defaultValue = "5") int pageSize){
		return userService.getSearchUsers(searched,pageNo,pageSize);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> getUserById (@PathVariable String id){
		return userService.getUserById(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<User>deleteUserById(@PathVariable String id){
		return userService.deleteUserById(id);
	}
	
}
