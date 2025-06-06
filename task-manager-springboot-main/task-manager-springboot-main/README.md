# 🧠 Task Manager Spring Boot – Integración RabbitMQ

Este proyecto es parte del sistema de gestión de tareas con arquitectura por módulos, desarrollado con **Spring Boot** y **RabbitMQ** para manejar eventos asincrónicos.

---

## 🚀 Características principales

* API REST para gestión de tareas (`/api/tasks`)
* Envió de eventos a RabbitMQ cuando se crea una nueva tarea
* Listener que consume automáticamente los mensajes de la cola `taskQueue`
* Integración modular con servicios, controladores y configuración separada

---

## ⚙️ Tecnologías usadas

* Java 22
* Spring Boot 3.5.0
* RabbitMQ (cola de mensajes)
* Spring AMQP (`spring-boot-starter-amqp`)
* Maven
* MariaDB / MySQL (para persistencia de tareas)

---

## 📦 Configuración de RabbitMQ

### Dependencia en `pom.xml`

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
```

### Configuración en `application.properties`

```properties
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```

### Clase de configuración: `RabbitMQConfig.java`

```java
@Configuration
public class RabbitMQConfig {
    public static final String TASK_QUEUE = "taskQueue";

    @Bean
    public Queue taskQueue() {
        return new Queue(TASK_QUEUE, false);
    }
}
```

---

## ✉️ Envió de eventos a RabbitMQ

### Servicio: `TaskEventSenderService.java`

```java
@Service
public class TaskEventSenderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendTaskCreatedEvent(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.TASK_QUEUE, message);
        System.out.println("✅ Mensaje enviado a RabbitMQ: " + message);
    }
}
```

### Controlador: `TaskController.java`

```java
@PostMapping
public Task createTask(@RequestBody Task task) {
    Task savedTask = taskService.save(task);

    String message = "Nueva tarea creada: ID=" + savedTask.getId() +
                     ", descripción=" + savedTask.getDescription();
    taskEventSenderService.sendTaskCreatedEvent(message);

    return savedTask;
}
```

---

## 📥 Listener: consumo automático de mensajes

### Clase: `TaskEventListener.java`

```java
@Component
public class TaskEventListener {

    @RabbitListener(queues = RabbitMQConfig.TASK_QUEUE)
    public void receiveMessage(String message) {
        System.out.println("📥 Mensaje recibido desde RabbitMQ: " + message);
    }
}
```

---

## ✅ Pruebas

1. Ejecutá RabbitMQ localmente o en Docker
2. Iniciá el proyecto Spring Boot
3. Hacé un POST a `/api/tasks` con un JSON como:

```json
{
  "description": "Estudiar RabbitMQ",
  "completed": false
}
```

4. Verás en consola:

   * ✉️ Mensaje enviado a RabbitMQ
   * 📥 Mensaje recibido por el listener

---

## 🧾 Autor

**Carlos Valiente** 

---

## 📌 Recomendaciones

* Asegurate de tener RabbitMQ corriendo antes de iniciar el backend.
* Podés monitorear los mensajes usando el panel en: `http://localhost:15672` (user/pass: guest/guest)
* Esta estructura permite escalar el sistema para notificaciones, logs, auditoría y mucho más.

---

🚀 **Listo para producción y eventos en tiempo real**
