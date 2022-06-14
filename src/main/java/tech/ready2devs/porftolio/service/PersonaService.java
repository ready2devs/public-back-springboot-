package tech.ready2devs.porftolio.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ready2devs.porftolio.model.Persona;
import tech.ready2devs.porftolio.repo.PersonaRepo;


import java.util.List;

@Service
public class PersonaService {
    private final PersonaRepo personaRepo;


    @Autowired
    public PersonaService(PersonaRepo personaRepo) {
        this.personaRepo = personaRepo;
    }

    public Persona addPersona(Persona person){
        return personaRepo.save(person);
    }

    public List<Persona> findAllPersonas() {
        return personaRepo.findAll();
    }

    public Persona updatePersona(Persona person) {
        return personaRepo.save(person);
    }


    public Persona getOnePersona(Long id) {
        return personaRepo.findById(id).orElse(null);
    }


    public void deletePersona(Long id) {
        personaRepo.deleteById(id);
    }

    public boolean existPersonaById(Long id){
        return personaRepo.existsById(id);
    }

}


