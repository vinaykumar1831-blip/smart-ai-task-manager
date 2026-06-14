package com.vinay.smart_ai_task_manager.controller;

import jakarta.validation.Valid;

import com.vinay.smart_ai_task_manager.entity.Task;
import com.vinay.smart_ai_task_manager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTask();
    }
    @GetMapping("/status/{status}")
public List<Task> getTasksByStatus(@PathVariable String status) {
    return taskService.getTasksByStatus(status);
}

@GetMapping("/priority/{priority}")
public List<Task> getTasksByPriority(@PathVariable String priority) {
    return taskService.getTasksByPriority(priority);
}
@PostMapping
public Task createTask(@Valid @RequestBody Task task) {
    return taskService.createTask(task);
}
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
        
    }
    @PutMapping("/{id}")
public Task updateTask(@PathVariable Long id, @Valid @RequestBody Task task) {
    return taskService.updateTask(id, task);
}
    @DeleteMapping("/{id}")
public String deleteTask(@PathVariable Long id) {
    taskService.deleteTask(id);
    return "Task deleted successfully";
}
}