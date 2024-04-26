package com.example.todo.controller.task;

import java.util.List;
import java.util.Optional;

import com.example.todo.service.task.TaskSearchEntity;
import com.example.todo.service.task.TaskStatus;

public record TaskSearchForm(String summary, List<String> status) {
  public TaskSearchEntity toEntity() {
    var statusEntityList = Optional.ofNullable(status()) // NULLの可能性があるリスト
        .map(statusList -> statusList.stream().map(TaskStatus::valueOf).toList()) // NULLでない場合
        .orElse(List.of()); // NULLの場合
    return new TaskSearchEntity(summary(), statusEntityList);
  }

  public TaskSearchDTO toDTO() {
    return new TaskSearchDTO(summary(), status());
  }
}
