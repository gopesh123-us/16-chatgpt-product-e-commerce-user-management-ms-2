package live.learnjava.ecommerce_user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import live.learnjava.ecommerce_user.entities.User;
import live.learnjava.ecommerce_user.exception.ResourceExistsException;
import live.learnjava.ecommerce_user.exception.ResourceNotFoundException;
import live.learnjava.ecommerce_user.repositories.IUserRepository;
import live.learnjava.ecommerce_user.service.IUserService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {
	// use repo

	@Autowired
	private IUserRepository userRepo;

	@Override
	public User saveUser(User user) {
		// if user already exists throw exception
		if (!userRepo.existsByEmail(user.getEmail())) {
			log.info("Saving user!");
			return userRepo.save(user);
		} else {
			throw new ResourceExistsException("User with Email " + user.getEmail() + " already exists.");
		}
	}

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public User findUserById(Long userId) {
		log.info("Finding user with ID: {}", userId);
		return userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with userId: " + userId));
	}

	@Override
	public User updateUser(User user) {
		if (this.userExists(user.getId())) {
			log.info("Updating user with ID: {}", user.getId());
			return userRepo.save(user);
		} else {
			throw new ResourceNotFoundException("User with ID " + user.getId() + " not found for updation.");
		}
	}

	@Override
	public String deleteUser(Long userId) {
		boolean userExists = this.userExists(userId);
		if (userExists) {
			userRepo.deleteById(userId);
			log.info("Deleting user with ID: {}" + userId);
			return "User successfully deleted with userId: " + userId;
		} else {
			return "User with userId: " + userId + " not found";
		}
	}

	@Override
	public boolean userExists(Long userId) {
		System.out.println("Checking user");
		return userRepo.existsById(userId);
	}

}
