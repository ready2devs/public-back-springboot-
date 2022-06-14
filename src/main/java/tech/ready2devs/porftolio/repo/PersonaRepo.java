package tech.ready2devs.porftolio.repo;

import tech.ready2devs.porftolio.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PersonaRepo extends JpaRepository<Persona, Long>{


    Optional<Persona> findPersonById(Long id);


    void deletePersonById(Long id);

}
