package umg.edu.gt.taskmanagerspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umg.edu.gt.persistence.model.Task;
import umg.edu.gt.persistence.service.TaskService;
import umg.edu.gt.taskmanagerspringboot.service.TaskEventSenderService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskEventSenderService taskEventSenderService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        Task savedTask = taskService.save(task);

        // Enviar evento a RabbitMQ
        String message = "Nueva tarea creada: ID=" + savedTask.getId() +
                         ", descripción=" + savedTask.getDescription();
        taskEventSenderService.sendTaskCreatedEvent(message);

        return savedTask;
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
        return "✅ Tarea eliminada con ID: " + id;
    }
}
