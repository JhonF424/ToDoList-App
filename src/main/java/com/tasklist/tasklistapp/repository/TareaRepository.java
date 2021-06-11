package com.tasklist.tasklistapp.repository;

import com.tasklist.tasklistapp.model.Tarea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends CrudRepository<Tarea, Long>{
    
}
