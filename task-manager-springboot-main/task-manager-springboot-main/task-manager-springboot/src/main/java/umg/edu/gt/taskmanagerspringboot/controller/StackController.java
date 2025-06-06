package umg.edu.gt.taskmanagerspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umg.edu.gt.taskmanagerspringboot.service.StackManagerService;

@RestController
@RequestMapping("/api/stack")
public class StackController {

    @Autowired
    private StackManagerService stackService;

    @PostMapping("/push")
    public String push(@RequestParam String value) {
        stackService.push(value);
        return "✅ Valor agregado: " + value;
    }

    @PostMapping("/pop")

    public String pop() {
        try {
            return "🧹 Valor removido: " + stackService.pop();
        } catch (IllegalStateException e) {
            return "⚠️ Error: " + e.getMessage();
        }
    }

    @GetMapping("/peek")
    public String peek() {
        try {
            return "🔍 Tope de la pila: " + stackService.peek();
        } catch (IllegalStateException e) {
            return "⚠️ Error: " + e.getMessage();
        }
    }

    @GetMapping("/is-empty")
    public boolean isEmpty() {
        return stackService.isEmpty();
    }

    @GetMapping("/size")
    public int size() {
        return stackService.size();
    }
    

}
