package com.vinay.smart_ai_task_manager.repository;

import com.vinay.smart_ai_task_manager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(String status);

    List<Task> findByPriority(String priority);

    List<Task> findByOrderByCreatedAtDesc();
}