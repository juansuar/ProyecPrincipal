package umg.edu.gt.taskmanagerspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umg.edu.gt.persistence.model.User;
import umg.edu.gt.persistence.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/test") // Prefijo común
public class TestController {

    @Autowired
    private UserService userService;

    // GET: Listar todos los usuarios
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    // POST: Crear un nuevo usuario
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }
}
