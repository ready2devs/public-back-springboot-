package tech.ready2devs.porftolio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ready2devs.porftolio.dto.MensajeExperiencia;
import tech.ready2devs.porftolio.model.Experiencia;
import tech.ready2devs.porftolio.service.ExperienciaService;


import java.util.List;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = "*")
public class ExperienciaController {

    private final ExperienciaService experienciaService;

    public ExperienciaController(ExperienciaService experienciaService) {
        this.experienciaService = experienciaService;
    }

    @GetMapping("/todas")
    public ResponseEntity<List<Experiencia>> getAllExperiencias() {
        List<Experiencia> experiencias = experienciaService.findAllExperiencias();
        return new ResponseEntity<>(experiencias, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Experiencia> getOneExperiencia (@PathVariable("id") Long id){
        if(!experienciaService.existExperienciaById(id))
            return new ResponseEntity(new MensajeExperiencia("no existe"), HttpStatus.NOT_FOUND);

        Experiencia exp = experienciaService.getOneExperiencia(id);
        return new ResponseEntity<>(exp, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Experiencia> addExperiencia(@RequestBody Experiencia exp) {
        Experiencia newExperiencia = experienciaService.addExperiencia(exp);
        return new ResponseEntity<>(newExperiencia, HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity<Experiencia> updateExperiencia(@RequestBody Experiencia exp) {
        Experiencia updateExperiencia = experienciaService.updateExperiencia(exp);
        return new ResponseEntity<>(updateExperiencia, HttpStatus.OK);
    }

    @DeleteMapping ("/borrar/{id}")
    public void deleteExperiencia(@PathVariable("id") Long id){
        experienciaService.deleteExperiencia(id);

    }



}
