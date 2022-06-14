package tech.ready2devs.porftolio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ready2devs.porftolio.model.Usuario;

import java.util.List;

@Repository
public interface AuthRepo extends JpaRepository<Usuario, Long> {
    List<Usuario> findByEmailAndIsEnabledTrue(String email);
}
