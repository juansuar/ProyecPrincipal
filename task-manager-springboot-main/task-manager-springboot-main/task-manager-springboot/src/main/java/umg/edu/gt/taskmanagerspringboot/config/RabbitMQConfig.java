package umg.edu.gt.taskmanagerspringboot.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String TASK_QUEUE = "taskQueue";

    @Bean
    public Queue taskQueue() {
        return new Queue(TASK_QUEUE, false); // false = no durable (puedes cambiarlo si quieres que sobreviva reinicios)
    }
}
