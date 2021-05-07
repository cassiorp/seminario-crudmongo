package com.seminario.crudmongodb.service;

import com.seminario.crudmongodb.dto.TaskDto;
import com.seminario.crudmongodb.dto.UpdateSituationDto;
import com.seminario.crudmongodb.model.TaskEntity;
import com.seminario.crudmongodb.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskEntity save(TaskDto taskDto) {
        TaskEntity taskEntity = new TaskEntity(taskDto.getTitle(), taskDto.getDescription());
        return this.taskRepository.save(taskEntity);
    }

    public List<TaskEntity> findAll() {
        return this.taskRepository.findAll();
    }

    public TaskEntity findById(String id) {
        return this.taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));
    }

    public TaskEntity findByTitulo(String titulo) {
        return Optional.ofNullable(this.taskRepository.findByTitle(titulo))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));
    }

    public TaskEntity updateSituation(String id, UpdateSituationDto updateSituationDto){
        TaskEntity taskEntity = this.findById(id);
        taskEntity.setSituation(updateSituationDto.getSituation());
        taskEntity = this.taskRepository.save(taskEntity);
        return taskEntity;
    }

    public boolean deleteById(String id) {
        this.taskRepository.deleteById(id);
        if(this.taskRepository.existsById(id)){
            return false;
        }
        return true;
    }
}
