package umg.edu.gt.taskmanagerspringboot.controller;

import org.springframework.web.bind.annotation.*;
import umg.edu.gt.structures.service.PriorityQueueService;

@RestController
@RequestMapping("/api/priority-queue")
public class PriorityQueueController {

    private final PriorityQueueService<Integer> priorityQueueService;

    public PriorityQueueController() {
        this.priorityQueueService = new PriorityQueueService<>();
    }

    @PostMapping("/enqueue")
    public String enqueue(@RequestParam int value) {
        priorityQueueService.enqueue(value);
        return "Valor " + value + " encolado con prioridad.";
    }

    @PostMapping("/dequeue")
    public String dequeue() {
        Integer value = priorityQueueService.dequeue();
        if (value == null) return "La cola está vacía.";
        return "Valor desencolado: " + value;
    }

    @GetMapping("/peek")
    public String peek() {
        Integer value = priorityQueueService.peek();
        if (value == null) return "La cola está vacía.";
        return "Valor con mayor prioridad: " + value;
    }

    @GetMapping("/is-empty")
    public boolean isEmpty() {
        return priorityQueueService.isEmpty();
    }

    @GetMapping("/is-full")
    public boolean isFull() {
        return priorityQueueService.isFull();
    }

    @GetMapping("/size")
    public int size() {
        return priorityQueueService.size();
    }
}
