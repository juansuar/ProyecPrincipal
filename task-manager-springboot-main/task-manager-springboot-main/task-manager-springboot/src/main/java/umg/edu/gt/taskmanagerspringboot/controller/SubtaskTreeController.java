package umg.edu.gt.taskmanagerspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umg.edu.gt.taskmanagerspringboot.structures.SubtaskNode;
import umg.edu.gt.taskmanagerspringboot.service.SubtaskTreeService;

import java.util.Map;

@RestController
@RequestMapping("/api/tree")
public class SubtaskTreeController {

    @Autowired
    private SubtaskTreeService subtaskTreeService;

    @PostMapping("/root")
    public SubtaskNode createRoot(@RequestParam String name) {
        return subtaskTreeService.createRoot(name);
    }

    @PostMapping("/add")
    public SubtaskNode addSubtask(@RequestParam Long parentId, @RequestParam String name) {
        return subtaskTreeService.addSubtask(parentId, name);
    }

    @GetMapping("/node/{id}")
    public SubtaskNode getSubtask(@PathVariable Long id) {
        return subtaskTreeService.getSubtask(id);
    }

    @GetMapping("/all")
    public Map<Long, SubtaskNode> getAllNodes() {
        return subtaskTreeService.getAllNodes();
    }
}
