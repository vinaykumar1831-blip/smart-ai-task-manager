package com.vinay.smart_ai_task_manager.service;

import com.vinay.smart_ai_task_manager.entity.Task;
import com.vinay.smart_ai_task_manager.exception.TaskNotFoundException;
import com.vinay.smart_ai_task_manager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
public Task getTaskById(Long id) {
    return taskRepository.findById(id)
            .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
}
    @Override
public void deleteTask(Long id) {
    taskRepository.deleteById(id);
}
@Override
public List<Task> getTasksByStatus(String status) {
    return taskRepository.findByStatus(status);
}
@Override
public List<Task> getLatestTasks() {
    return taskRepository.findByOrderByCreatedAtDesc();
}

@Override
public List<Task> getTasksByPriority(String priority) {
    return taskRepository.findByPriority(priority);
}
@Override
public Task updateTask(Long id, Task task) {
    Task existingTask = taskRepository.findById(id).orElse(null);

    if (existingTask != null) {
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setStatus(task.getStatus());
        existingTask.setPriority(task.getPriority());
        existingTask.setDueDate(task.getDueDate());

        return taskRepository.save(existingTask);
    }

    return null;
}
}