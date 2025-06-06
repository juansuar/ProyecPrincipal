package umg.edu.gt.taskmanagerspringboot.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umg.edu.gt.taskmanagerspringboot.config.RabbitMQConfig;

@Service
public class TaskEventSenderService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public TaskEventSenderService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendTaskCreatedEvent(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.TASK_QUEUE, message);
        System.out.println("✅ Mensaje enviado a RabbitMQ: " + message);
    }
}
