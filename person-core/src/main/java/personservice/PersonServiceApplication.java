package personservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan("personservice")
public class PersonServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonServiceApplication.class);
    }
}
