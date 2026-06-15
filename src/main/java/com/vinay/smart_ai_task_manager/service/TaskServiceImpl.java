package com.vinay.smart_ai_task_manager.service;

import com.vinay.smart_ai_task_manager.dto.TaskStatsDTO;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
public TaskStatsDTO getTaskStats() {

    long totalTasks = taskRepository.count();

    long completedTasks =
            taskRepository.countByStatus("COMPLETED");

    long pendingTasks =
            taskRepository.countByStatus("PENDING");

    return new TaskStatsDTO(
            totalTasks,
            completedTasks,
            pendingTasks
    );
}
    @Override
public List<Task> searchTasks(String keyword) {
    return taskRepository.findByTitleContainingIgnoreCase(keyword);
}
@Override
public Page<Task> getAllTasks(Pageable pageable, String sortBy) {

    Pageable sortedPageable = PageRequest.of(
            pageable.getPageNumber(),
            pageable.getPageSize(),
            Sort.by(sortBy)
    );

    return taskRepository.findAll(sortedPageable);
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
public Page<Task> getAllTasks(Pageable pageable) {
    return taskRepository.findAll(pageable);
}
@Override
public List<Task> getAllTasksSorted(String field) {
    return taskRepository.findAll(Sort.by(Sort.Direction.ASC, field));
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