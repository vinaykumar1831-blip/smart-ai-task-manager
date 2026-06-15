package com.vinay.smart_ai_task_manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskStatsDTO {

    private long totalTasks;
    private long completedTasks;
    private long pendingTasks;
}