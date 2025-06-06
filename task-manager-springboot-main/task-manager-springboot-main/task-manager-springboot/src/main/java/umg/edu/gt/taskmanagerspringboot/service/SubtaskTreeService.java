package umg.edu.gt.taskmanagerspringboot.service;

import java.util.HashMap;
import java.util.Map;
import umg.edu.gt.taskmanagerspringboot.structures.SubtaskNode;
import org.springframework.stereotype.Service;

@Service
public class SubtaskTreeService {

    private Map<Long, SubtaskNode> nodeMap = new HashMap<>();
    private long nextId = 1L;

    public SubtaskNode createRoot(String name) {
        SubtaskNode root = new SubtaskNode(nextId++, name);
        nodeMap.put(root.getId(), root);
        return root;
    }

    public SubtaskNode addSubtask(Long parentId, String name) {
        SubtaskNode parent = nodeMap.get(parentId);
        if (parent == null) return null;

        SubtaskNode child = new SubtaskNode(nextId++, name);
        parent.addChild(child);
        nodeMap.put(child.getId(), child);
        return child;
    }

    public SubtaskNode getSubtask(Long id) {
        return nodeMap.get(id);
    }

    public Map<Long, SubtaskNode> getAllNodes() {
        return nodeMap;
    }
}
