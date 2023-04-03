package com.darkworldbank.user.contoller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.darkworldbank.user.model.User;
import com.darkworldbank.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/bankuser")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class.getSimpleName());

	@Autowired
	private UserService userService;

	//save one user
	@PostMapping(value = "/enterUser", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		log.info("**************ROSHAN : USER DETAILS ENTERED************ ");
		log.info("User ->  " + user);
		User user2 = userService.save(user);
		return ResponseEntity.ok().body(user);
	}
    //getone by id
	@GetMapping(value = "/getUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserDetails(@PathVariable(name = "id") int id) {
		return ResponseEntity.ok(userService.get(id));
	}

	//get all in list
	@GetMapping(value = "/getAllUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUserDetails() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	//edit
	@PutMapping("/editUser/{id}")
	public ResponseEntity<User> edit(@PathVariable(name = "id") int id, @RequestBody User user) {
		User user2 = userService.get(id);
		user2.setUserName(user.getUserName());
		user2.setUserAge(user.getUserAge());
		user2.setEmailId(user.getEmailId());
		userService.save(user2);
		return ResponseEntity.ok(user2);
	}

	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		userService.delete(id);
		return ResponseEntity.ok("deleted sucessfully");
	}
	
	//by name
	@PostMapping("/getByName/{name}")
	public ResponseEntity<User> getUserByName(@PathVariable(name = "name") String name){
		return ResponseEntity.ok(userService.getByUserName(name));
	}
	
	//by name and age
	@PostMapping("/getByNameAndAge/{name}")
	public ResponseEntity<User> getByNameAndAge(@PathVariable(name = "name") String name,@PathVariable(name = "id") int age){
		return ResponseEntity.ok(userService.getByUserNameAndAge(name,age));
	}
	
	

	
	

}


