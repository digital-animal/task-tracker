package com.zahid.task;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllEntities() {
        return taskRepository.findAll();
    }

    public Task getEntityById(UUID id) {
        return taskRepository.findById(id).get();
    }

    public Task createEntity(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> createEntities(List<Task> tasks) {
        return taskRepository.saveAll(tasks);
    }

    public Task updateEntity(Task updatedEntity) {
        return taskRepository.save(updatedEntity);
    }

    public Boolean deleteEntity(UUID id) {
        taskRepository.deleteById(id);
        return true;
    }

    public Boolean deleteAllEntities() {
        taskRepository.deleteAll();
        return true;
    }

}
