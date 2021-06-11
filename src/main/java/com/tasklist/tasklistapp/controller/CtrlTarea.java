package com.tasklist.tasklistapp.controller;

import com.tasklist.tasklistapp.model.Tarea;
import com.tasklist.tasklistapp.service.TareaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "/")
public class CtrlTarea {
    
    @Autowired
    private TareaService tareaService;
    
    @GetMapping(path = "/")
    public String listarTareas(Model model){
        List<Tarea> listaTareas = tareaService.listar();
        model.addAttribute("tareas", listaTareas);
        
        Tarea tarea = new Tarea();
        model.addAttribute("tarea", tarea);
        return "index";
    }
    
    @PostMapping(path = "/save")
    public String guardarTarea(@ModelAttribute Tarea tarea, Model model, 
            RedirectAttributes attribute){
        tareaService.guardar(tarea);
        return "redirect:/";
    }
    
    @GetMapping(path = "/eliminar/{id}")
    public String eliminarTarea(@PathVariable("id") Long idTarea, RedirectAttributes attribute){
        Tarea tarea = null;
        
        if (idTarea > 0) {
            tarea = tareaService.buscarTarea(idTarea);

            if (tarea == null) {
                System.out.println("Error: El ID seleccionado no existe");
                return "redirect:/index";
            }
        } else {
            System.out.println("Error: El ID seleccionado no es válido");
            return "redirect:/index";
        }
        
        tareaService.eliminar(idTarea);
        System.out.println("Registro eliminado con éxito");
        return "redirect:/";
    }
    
}
