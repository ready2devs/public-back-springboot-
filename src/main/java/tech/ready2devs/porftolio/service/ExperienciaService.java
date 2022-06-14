package tech.ready2devs.porftolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.ready2devs.porftolio.model.Experiencia;
import tech.ready2devs.porftolio.model.Persona;
import tech.ready2devs.porftolio.repo.ExperienciaRepo;
import tech.ready2devs.porftolio.repo.PersonaRepo;

import java.util.List;

@Service
@Transactional
public class ExperienciaService {
    private final ExperienciaRepo experienciaRepo;


    @Autowired
    public ExperienciaService(ExperienciaRepo experienciaRepo) {
        this.experienciaRepo = experienciaRepo;
    }

    public Experiencia addExperiencia(Experiencia exp){
        return experienciaRepo.save(exp);
    }

    public List<Experiencia> findAllExperiencias() {
        return experienciaRepo.findAll();
    }

    public Experiencia updateExperiencia(Experiencia exp) {
        return experienciaRepo.save(exp);
    }

    public Experiencia getOneExperiencia(Long id) {
        return experienciaRepo.findById(id).orElse(null);
    }

    public void deleteExperiencia(Long id) {
        experienciaRepo.deleteById(id);
    }

    public boolean existExperienciaById(Long id){
        return experienciaRepo.existsById(id);
    }

}
