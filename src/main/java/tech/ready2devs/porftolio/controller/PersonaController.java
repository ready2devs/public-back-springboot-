package tech.ready2devs.porftolio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ready2devs.porftolio.dto.MensajePersona;
import tech.ready2devs.porftolio.model.Persona;
import tech.ready2devs.porftolio.service.PersonaService;

import java.util.List;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "*")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/todas")
    public ResponseEntity<List<Persona>> getAllPersonas () {
        List<Persona> personas = personaService.findAllPersonas();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Persona> getOnePersona (@PathVariable("id") Long id){
        if(!personaService.existPersonaById(id))
            return new ResponseEntity(new MensajePersona("no existe"), HttpStatus.NOT_FOUND);

        Persona person = personaService.getOnePersona(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Persona> addPersona(@RequestBody Persona person) {
        Persona newPersona = personaService.addPersona(person);
        return new ResponseEntity<>(newPersona, HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity<Persona> updatePersona(@RequestBody Persona person) {
        Persona updatePersona = personaService.updatePersona(person);
        return new ResponseEntity<>(updatePersona, HttpStatus.OK);
    }

    @DeleteMapping ("/borrar/{id}")
    public void deletePersona(@PathVariable("id") Long id){
        personaService.deletePersona(id);

    }


}





