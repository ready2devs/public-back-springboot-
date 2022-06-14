package tech.ready2devs.porftolio.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ready2devs.porftolio.model.Experiencia;

@Repository
public interface ExperienciaRepo extends JpaRepository<Experiencia, Long> {

}
