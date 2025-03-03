package live.learnjava.ecommerce_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
