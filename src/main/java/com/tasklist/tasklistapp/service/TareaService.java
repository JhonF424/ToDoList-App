package com.tasklist.tasklistapp.service;

import com.tasklist.tasklistapp.model.Tarea;
import java.util.List;
import org.springframework.stereotype.Service;

public interface TareaService {
    public List<Tarea> listar();
    public void guardar(Tarea tarea);
    public Tarea buscarTarea(Long id);
    public void eliminar(Long id);
}
