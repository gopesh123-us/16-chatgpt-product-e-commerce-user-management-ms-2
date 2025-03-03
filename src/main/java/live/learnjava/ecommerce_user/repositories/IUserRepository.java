package live.learnjava.ecommerce_user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import live.learnjava.ecommerce_user.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	boolean existsByEmail(String email);
}
