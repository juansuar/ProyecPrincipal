package umg.edu.gt.taskmanagerspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umg.edu.gt.persistence.model.TaskHistory;
import umg.edu.gt.persistence.service.TaskHistoryService;

import java.util.List;

@RestController
@RequestMapping("/api/task-history")
public class TaskHistoryController {

    @Autowired
    private TaskHistoryService taskHistoryService;

    // GET: Listar historial
    @GetMapping
    public List<TaskHistory> getAllTaskHistory() {
        return taskHistoryService.findAll();
    }

    // POST: Crear historial
    @PostMapping
    public TaskHistory createTaskHistory(@RequestBody TaskHistory taskHistory) {
        return taskHistoryService.save(taskHistory);
    }
}
