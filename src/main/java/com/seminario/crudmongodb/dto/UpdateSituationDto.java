package com.seminario.crudmongodb.dto;

import com.seminario.crudmongodb.model.Situation;

public class UpdateSituationDto {

    private Situation situation;

    public UpdateSituationDto(Situation situation) {
        this.situation = situation;
    }

    public UpdateSituationDto() {
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }
}
