package com.vinay.smart_ai_task_manager.controller;

import com.vinay.smart_ai_task_manager.dto.TaskStatsDTO;

import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vinay.smart_ai_task_manager.entity.Task;
import com.vinay.smart_ai_task_manager.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Task Controller", description = "Task Management APIs")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Get all tasks")
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTask();
    }
    @Operation(summary = "Search tasks by title")
@GetMapping("/search")
public List<Task> searchTasks(@RequestParam String keyword) {
    return taskService.searchTasks(keyword);
}
    @Operation(summary = "Get paginated and sorted tasks")
@GetMapping("/page-sort")
public Page<Task> getTasksWithPaginationAndSorting(
        @RequestParam int page,
        @RequestParam int size,
        @RequestParam String sortBy) {

    Pageable pageable = PageRequest.of(page, size);

    return taskService.getAllTasks(pageable, sortBy);
}
@Operation(summary = "Get task statistics")
@GetMapping("/stats")
public TaskStatsDTO getTaskStats() {
    return taskService.getTaskStats();
}
    @Operation(summary = "Get paginated tasks")
@GetMapping("/page")
public Page<Task> getAllTasks(Pageable pageable) {
    return taskService.getAllTasks(pageable);
}

    @Operation(summary = "Get tasks by status")
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable String status) {
        return taskService.getTasksByStatus(status);
    }
    @Operation(summary = "Get tasks sorted by field")
@GetMapping("/sort/{field}")
public List<Task> getAllTasksSorted(@PathVariable String field) {
    return taskService.getAllTasksSorted(field);
}
    @Operation(summary = "Get tasks by priority")
    @GetMapping("/priority/{priority}")
    public List<Task> getTasksByPriority(@PathVariable String priority) {
        return taskService.getTasksByPriority(priority);
    }

    @Operation(summary = "Create a new task")
    @PostMapping
    public Task createTask(@Valid @RequestBody Task task) {
        return taskService.createTask(task);
    }

    @Operation(summary = "Get task by ID")
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @Operation(summary = "Update task")
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id,
                           @Valid @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @Operation(summary = "Delete task")
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Task deleted successfully";
    }
    @Operation(summary = "Get latest tasks")
@GetMapping("/latest")
public List<Task> getLatestTasks() {
    return taskService.getLatestTasks();
}
}