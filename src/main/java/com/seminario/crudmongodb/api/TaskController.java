package com.seminario.crudmongodb.api;

import com.seminario.crudmongodb.dto.TaskDto;
import com.seminario.crudmongodb.dto.UpdateSituationDto;
import com.seminario.crudmongodb.model.TaskEntity;
import com.seminario.crudmongodb.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Api("API para tarefas")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping
    @ApiOperation("Busca todas tarefas")
    public List<TaskEntity> getAll(){
        return this.taskService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca tarefa por id")
    public TaskEntity getById(@PathVariable String id){
        return this.taskService.findById(id);
    }

    @ResponseStatus(CREATED)
    @PostMapping
    @ApiOperation("Cria uma tarefa")
    public TaskEntity create(@RequestBody TaskDto taskDto){
        return this.taskService.save(taskDto);
    }

    @PatchMapping
    @ApiOperation("Atualiza situação da terefa")
    public TaskEntity upadte(
            @RequestParam(value = "id", required = true) String id,
            @Valid @RequestBody UpdateSituationDto updateSituationDto
    ){
        return this.taskService.updateSituation(id, updateSituationDto);
    }


    @DeleteMapping("/{id}")
    @ApiOperation("Deleta tarefa por id")
    public boolean delete(@PathVariable String id){
        return this.taskService.deleteById(id);
    }


}
