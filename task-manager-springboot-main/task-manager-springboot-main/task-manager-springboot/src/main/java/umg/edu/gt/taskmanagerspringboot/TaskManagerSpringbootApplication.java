package umg.edu.gt.taskmanagerspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
        "umg.edu.gt.taskmanagerspringboot",
        "umg.edu.gt.persistence.service"
})
@EnableJpaRepositories(basePackages = "umg.edu.gt.persistence.repository")
@EntityScan(basePackages = "umg.edu.gt.persistence.model")
public class TaskManagerSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerSpringbootApplication.class, args);
    }

}
