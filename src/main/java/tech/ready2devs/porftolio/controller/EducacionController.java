package tech.ready2devs.porftolio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ready2devs.porftolio.dto.MensajeEducacion;
import tech.ready2devs.porftolio.model.Educacion;
import tech.ready2devs.porftolio.service.EducacionService;

import java.util.List;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://lucianoleandrosica.web.app/")
public class EducacionController {
    private final EducacionService educacionService;

    public EducacionController(EducacionService educacionService) {
        this.educacionService = educacionService;
    }


    @GetMapping("/todas")
    public ResponseEntity<List<Educacion>> getAllEducaciones() {
        List<Educacion> educaciones = educacionService.findAllEducaciones();
        return new ResponseEntity<>(educaciones, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Educacion> getOneEducacion (@PathVariable("id") Long id){
        if(!educacionService.existEducacionById(id))
            return new ResponseEntity(new MensajeEducacion("no existe"), HttpStatus.NOT_FOUND);

        Educacion exp = educacionService.getOneEducacion(id);
        return new ResponseEntity<>(exp, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Educacion> addEducacion(@RequestBody Educacion edu) {
        Educacion newEducacion = educacionService.addEducacion(edu);
        return new ResponseEntity<>(newEducacion, HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity<Educacion> updateEducacion(@RequestBody Educacion edu) {
        Educacion updateEducacion = educacionService.updateEducacion(edu);
        return new ResponseEntity<>(updateEducacion, HttpStatus.OK);
    }

    @DeleteMapping ("/borrar/{id}")
    public void deleteEducacion(@PathVariable("id") Long id){
        educacionService.deleteEducacion(id);

    }



}
