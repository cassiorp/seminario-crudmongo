package com.seminario.crudmongodb.model;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Document(collection = "tasks")
public class TaskEntity {

    @Id
    @ApiModelProperty(notes = "Id do banco", position = 0)
    private String id;

    @ApiModelProperty(notes = "Titulo da tarefa", position = 1)
    private String title;

    @ApiModelProperty(notes = "Descrição da tarefa", position = 2)
    private String description;

    @ApiModelProperty(notes = "Situação da tarefa", position = 3)
    private Situation situation;

    public TaskEntity(String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.situation = Situation.OPEN;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }
}
