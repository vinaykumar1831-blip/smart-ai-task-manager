package com.vinay.smart_ai_task_manager.service;

import com.vinay.smart_ai_task_manager.entity.Task;
import java.util.List;

public interface TaskService {

    Task createTask(Task task);

    List<Task> getAllTask();

    Task getTaskById(Long id);

    void deleteTask(Long id);

    Task updateTask(Long id, Task task);

    List<Task> getTasksByStatus(String status);

    List<Task> getTasksByPriority(String priority);
}