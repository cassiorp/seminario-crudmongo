package com.seminario.crudmongodb.dto;


import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TaskDto {

    @NotNull
    @NotEmpty
    @ApiModelProperty(position = 0)
    private String title;
    @NotNull
    @NotEmpty
    @ApiModelProperty(position = 1)
    private String description;

    public TaskDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public TaskDto() {
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
}
