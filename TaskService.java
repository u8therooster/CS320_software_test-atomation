package task;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> taskMap = new HashMap<>();

    public void addTask(Task task) {
        if (taskMap.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID already exists.");
        }
        taskMap.put(task.getTaskId(), task);
    }

    public void deleteTask(String taskId) {
        if (!taskMap.containsKey(taskId)) {
            throw new IllegalArgumentException("Task not found.");
        }
        taskMap.remove(taskId);
    }

    public void updateName(String taskId, String name) {
        Task task = getTask(taskId);
        task.setName(name);
    }

    public void updateDescription(String taskId, String description) {
        Task task = getTask(taskId);
        task.setDescription(description);
    }

    private Task getTask(String taskId) {
        Task task = taskMap.get(taskId);
        if (task == null) throw new IllegalArgumentException("Task not found.");
        return task;
    }

    public Task getTaskById(String taskId) {
        return taskMap.get(taskId);
    }
}
