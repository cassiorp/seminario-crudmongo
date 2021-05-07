package com.seminario.crudmongodb.repository;

import com.seminario.crudmongodb.model.TaskEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<TaskEntity, String> {

    TaskEntity findByTitle(String title);

}
