package umg.edu.gt.taskmanagerspringboot.service;

import org.springframework.stereotype.Service;
import umg.edu.gt.structures.stack.CustomStack;

@Service
public class StackService<T> {

    private final CustomStack<T> stack;

    public StackService() {
        this.stack = new CustomStack<>();
    }

    public void push(T value) {
        stack.push(value);
    }

    public T pop() {
        return stack.pop();
    }

    public T peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public boolean isFull() {
        return stack.isFull();
    }

    public int size() {
        return stack.size();
    }
}
