package umg.edu.gt.taskmanagerspringboot.service;

import umg.edu.gt.structures.stack.CustomStack;


import org.springframework.stereotype.Service;

@Service
public class StackTestService {

    private final CustomStack<String> stack = new CustomStack<>();

    public void push(String element) {
        stack.push(element);
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

    public String getAllElements() {
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append("\n");
        }
        return result.toString();
    }
}
