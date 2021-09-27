package com.sakthi.service.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sakthi.service.user.entity.User;
import com.sakthi.service.user.service.UserService;
import com.sakthi.service.user.test.UserGeneric;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Value("${spring.application.name}")
	private String appName;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	@Qualifier("admin")
	private UserGeneric adminUser;
	
	@Autowired
	@Qualifier("test")
	private UserGeneric testUser;
	
	
	@GetMapping("/")
	public ResponseEntity<Object> checkService() {
		String message = appName + " is working.. <br></br><b>HAPPY CODING!!!</b>";
		log.info("CALLED :: checkService");
		return ResponseEntity.ok().body(message);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Object> getAllUsers() {
		List<User> users = userService.getAllUsers();
		log.info("Found {} users...");
		return ResponseEntity.ok().body(users);
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		userService.saveUser(user);
		log.info("Used saved successfully...");
		return ResponseEntity.ok().body(user);
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<Object> delete(@PathVariable Long userId) {
		userService.delete(userId);
		log.info("Used deleted successfully...");
		return ResponseEntity.ok().body("User deleted successfully...");
	}
	
	@GetMapping("/testUser")
	public ResponseEntity<Object> getTestUser() {
		return ResponseEntity.ok().body(testUser.info());
	}
	
	@GetMapping("/adminUser")
	public ResponseEntity<Object> getAdminUser() {
		return ResponseEntity.ok().body(adminUser.info());
	}
	
}
