package tech.ready2devs.porftolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.ready2devs.porftolio.model.Proyectos;
import tech.ready2devs.porftolio.repo.ProyectosRepo;


import java.util.List;

@Service
@Transactional
public class ProyectosService {

    private final ProyectosRepo proyectosRepo;

    @Autowired
    public ProyectosService(ProyectosRepo proyectosRepo) {
        this.proyectosRepo = proyectosRepo;
    }


    public Proyectos addProyecto(Proyectos pro) {
        return proyectosRepo.save(pro);
    }

    public List<Proyectos> findAllProyectos() {
        return proyectosRepo.findAll();
    }

    public Proyectos updateProyecto(Proyectos pro) {
        return proyectosRepo.save(pro);
    }

    public Proyectos getOneProyecto(Long id) {
        return proyectosRepo.findById(id).orElse(null);
    }

    public void deleteProyecto(Long id) {
        proyectosRepo.deleteById(id);
    }

    public boolean existProyectoById(Long id){
        return proyectosRepo.existsById(id);
    }


}
