package umg.edu.gt.taskmanagerspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umg.edu.gt.taskmanagerspringboot.service.QueueManagerService;

@RestController
@RequestMapping("/api/queue")
public class QueueController {

    @Autowired
    private QueueManagerService queueService;

    @PostMapping("/enqueue")
    public String enqueue(@RequestParam String value) {
        queueService.enqueue(value);
        return "Valor encolado correctamente: " + value;
    }

    @GetMapping("/dequeue")
    public String dequeue() {
        return queueService.dequeue();
    }

    @GetMapping("/peek")
    public String peek() {
        return queueService.peek();
    }

    @GetMapping("/is-empty")
    public boolean isEmpty() {
        return queueService.isEmpty();
    }

    @GetMapping("/is-full")
    public boolean isFull() {
        return queueService.isFull();
    }

    @GetMapping("/size")
    public int size() {
        return queueService.size();
    }
}
