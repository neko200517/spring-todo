package com.example.todo.service.task;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.repository.task.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

  private final TaskRepository taskRepository;

  public List<TaskEntity> find(TaskSearchEntity searchEntity) {
    return this.taskRepository.select(searchEntity);
  }

  public Optional<TaskEntity> findById(long taskId) {
    return taskRepository.selectById(taskId);
  }

  @Transactional
  public void create(TaskEntity newEntity) {
    taskRepository.insert(newEntity);
  }

  @Transactional
  public void update(TaskEntity entity) {
    taskRepository.update(entity);
  }

  @Transactional
  public void delete(long id) {
    taskRepository.delete(id);
  }
}
