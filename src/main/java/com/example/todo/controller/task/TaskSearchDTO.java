package com.example.todo.controller.task;

import java.util.List;
import java.util.Optional;

public record TaskSearchDTO(String summary, List<String> statusList) {
  public boolean isChecked(String status) {
    return Optional.ofNullable(statusList())
        .map(statusList -> statusList.contains(status))
        .orElse(false);
  }
}
