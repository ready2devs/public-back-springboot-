package tech.ready2devs.porftolio.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.ready2devs.porftolio.model.Educacion;
import tech.ready2devs.porftolio.model.Experiencia;
import tech.ready2devs.porftolio.repo.EducacionRepo;
import tech.ready2devs.porftolio.repo.ExperienciaRepo;

import java.util.List;

@Service
@Transactional
public class EducacionService {

    private final EducacionRepo educacionRepo;

    @Autowired
    public EducacionService(EducacionRepo educacionRepo) {
        this.educacionRepo = educacionRepo;
    }


    public Educacion addEducacion(Educacion edu){
        return educacionRepo.save(edu);
    }

    public List<Educacion> findAllEducaciones() {
        return educacionRepo.findAll();
    }

    public Educacion updateEducacion(Educacion edu) {
        return educacionRepo.save(edu);
    }

    public Educacion getOneEducacion(Long id) {
        return educacionRepo.findById(id).orElse(null);
    }

    public void deleteEducacion(Long id) {
        educacionRepo.deleteById(id);
    }

    public boolean existEducacionById(Long id){
        return educacionRepo.existsById(id);
    }


}
