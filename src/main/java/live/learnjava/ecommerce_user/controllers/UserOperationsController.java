package live.learnjava.ecommerce_user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import live.learnjava.ecommerce_user.entities.User;
import live.learnjava.ecommerce_user.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserOperationsController {
	// use service

	@Autowired
	private IUserService userRepo;

	@PostMapping("/saveuser")
	public ResponseEntity<User> saveUser(@RequestBody User theUser) {
		User savedUser = userRepo.saveUser(theUser);
		return new ResponseEntity<User>(savedUser, HttpStatus.OK);
	}

	@GetMapping("/findallusers")
	public ResponseEntity<List<User>> findAllUsers() {
		List<User> users = userRepo.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping("/finduser/{userId}")
	public ResponseEntity<User> findUserById(@PathVariable Long userId) {
		User foundUser = userRepo.findUserById(userId);
		return new ResponseEntity<User>(foundUser, HttpStatus.OK);
	}

	@PostMapping("/updateuser")
	public ResponseEntity<User> updateUser(@RequestBody User theUser) {
		User updatedUser = userRepo.updateUser(theUser);
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}

	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
		String message = userRepo.deleteUser(userId);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@GetMapping("/quickcheck/{userId}")
	public ResponseEntity<Boolean> userExists(@PathVariable Long userId) {
		Boolean status = userRepo.userExists(userId);
		return new ResponseEntity<Boolean>(status, HttpStatus.OK);
	}

}
