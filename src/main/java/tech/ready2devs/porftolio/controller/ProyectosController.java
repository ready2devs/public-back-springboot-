package tech.ready2devs.porftolio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ready2devs.porftolio.dto.MensajeProyectos;
import tech.ready2devs.porftolio.dto.MensajeSkills;
import tech.ready2devs.porftolio.model.Proyectos;
import tech.ready2devs.porftolio.model.Skills;
import tech.ready2devs.porftolio.service.ProyectosService;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "*")
public class ProyectosController {

    private final ProyectosService proyectosService;

    public ProyectosController(ProyectosService proyectosService) {
        this.proyectosService = proyectosService;
    }


    @GetMapping("/todos")
    public ResponseEntity<List<Proyectos>> getAllProyectos() {
        List<Proyectos> proyectos = proyectosService.findAllProyectos();
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Proyectos> getOneProyectos (@PathVariable("id") Long id){
        if(!proyectosService.existProyectoById(id))
            return new ResponseEntity(new MensajeProyectos("no existe"), HttpStatus.NOT_FOUND);

        Proyectos pro = proyectosService.getOneProyecto(id);
        return new ResponseEntity<>(pro, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Proyectos> addProyecto(@RequestBody Proyectos pro) {
        Proyectos newProyecto = proyectosService.addProyecto(pro);
        return new ResponseEntity<>(newProyecto, HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity<Proyectos> updateProyecto(@RequestBody Proyectos pro) {
        Proyectos updateProyecto = proyectosService.updateProyecto(pro);
        return new ResponseEntity<>(updateProyecto, HttpStatus.OK);
    }

    @DeleteMapping ("/borrar/{id}")
    public void deleteProyecto(@PathVariable("id") Long id){
        proyectosService.deleteProyecto(id);

    }




}
