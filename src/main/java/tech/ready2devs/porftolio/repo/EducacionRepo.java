package tech.ready2devs.porftolio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ready2devs.porftolio.model.Educacion;

@Repository
public interface EducacionRepo extends JpaRepository<Educacion, Long> {


}
