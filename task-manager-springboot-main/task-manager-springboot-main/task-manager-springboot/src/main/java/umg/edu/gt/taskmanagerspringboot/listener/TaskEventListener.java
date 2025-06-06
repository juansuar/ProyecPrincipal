package umg.edu.gt.taskmanagerspringboot.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import umg.edu.gt.taskmanagerspringboot.config.RabbitMQConfig;

@Component
public class TaskEventListener {

    @RabbitListener(queues = RabbitMQConfig.TASK_QUEUE)
    public void receiveMessage(String message) {
        System.out.println("📥 Mensaje recibido desde RabbitMQ: " + message);
        // Aquí podrías hacer más cosas: guardar logs, enviar notificaciones, etc.
    }
}
