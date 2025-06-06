package umg.edu.gt.taskmanagerspringboot.service;

import org.springframework.stereotype.Service;
import umg.edu.gt.structures.service.StackService;


@Service
public class StackManagerService {

    private final StackService<String> stack = new StackService<>();

    public void push(String value) {
        stack.push(value);
    }

    public String pop() {
        return stack.pop();
    }

    public String peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

}
