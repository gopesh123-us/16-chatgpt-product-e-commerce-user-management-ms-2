package live.learnjava.ecommerce_user.service;

import java.util.List;

import live.learnjava.ecommerce_user.entities.User;

public interface IUserService {

	// save new user
	User saveUser(User user);

	// findAllUsers
	List<User> findAll();

	// findUser
	User findUserById(Long userId);

	// update user
	User updateUser(User user);

	// delete user
	String deleteUser(Long userId);

	// quick check if user exists
	boolean userExists(Long userId);
}
