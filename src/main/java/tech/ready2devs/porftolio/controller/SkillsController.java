package tech.ready2devs.porftolio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ready2devs.porftolio.dto.MensajeSkills;
import tech.ready2devs.porftolio.model.Skills;
import tech.ready2devs.porftolio.service.SkillsService;

import java.util.List;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "*")
public class SkillsController {

    private final SkillsService skillsService;

    public SkillsController(SkillsService skillsService) {
        this.skillsService = skillsService;
    }


    @GetMapping("/todos")
    public ResponseEntity<List<Skills>> getAllSkills() {
        List<Skills> skills = skillsService.findAllSkills();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Skills> getOneSkills (@PathVariable("id") Long id){
        if(!skillsService.existSkillsById(id))
            return new ResponseEntity(new MensajeSkills("no existe"), HttpStatus.NOT_FOUND);

        Skills ski = skillsService.getOneSkills(id);
        return new ResponseEntity<>(ski, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Skills> addSkills(@RequestBody Skills ski) {
        Skills newSkills = skillsService.addSkills(ski);
        return new ResponseEntity<>(newSkills, HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity<Skills> updateEducacion(@RequestBody Skills ski) {
        Skills updateSkills = skillsService.updateSkills(ski);
        return new ResponseEntity<>(updateSkills, HttpStatus.OK);
    }

    @DeleteMapping ("/borrar/{id}")
    public void deleteSkills(@PathVariable("id") Long id){
        skillsService.deleteSkills(id);

    }


}
