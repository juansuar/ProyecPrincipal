package umg.edu.gt.taskmanagerspringboot.service;

import org.springframework.stereotype.Service;
import umg.edu.gt.structures.service.QueueService;

@Service
public class QueueManagerService {

    private final QueueService<String> queue = new QueueService<>();

    public void enqueue(String value) {
        queue.enqueue(value);
    }

    public String dequeue() {
        return queue.dequeue();
    }

    public String peek() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean isFull() {
        return queue.isFull();
    }

    public int size() {
        return queue.size();
    }
}
