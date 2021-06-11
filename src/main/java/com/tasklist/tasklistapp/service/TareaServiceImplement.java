package com.tasklist.tasklistapp.service;

import com.tasklist.tasklistapp.model.Tarea;
import com.tasklist.tasklistapp.repository.TareaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaServiceImplement implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public List<Tarea> listar() {

        return (List<Tarea>) tareaRepository.findAll();
    }

    @Override
    public void guardar(Tarea tarea) {
        tareaRepository.save(tarea);
    }

    @Override
    public Tarea buscarTarea(Long id) {
        return tareaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        tareaRepository.deleteById(id);
    }

}
