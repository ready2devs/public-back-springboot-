package tech.ready2devs.porftolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.ready2devs.porftolio.dto.UserDto;
import tech.ready2devs.porftolio.model.Usuario;
import tech.ready2devs.porftolio.repo.AuthRepo;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    AuthRepo repository;

    @Autowired
     PasswordEncoder passwordEncoder;

    public List<Usuario> findAllUsuarios() {
        return repository.findAll();
    }
    public boolean isUserEnabled(UserDto userDto) {
        boolean isUserEnabled = false;
        List<Usuario> usuarios = repository.findByEmailAndIsEnabledTrue(userDto.getEmail());
        if (!usuarios.isEmpty()) {
            Usuario usuario = usuarios.get(0);
            if (passwordEncoder.matches(userDto.getPassword(), usuario.getPassword()))
                isUserEnabled = true;
        }
        return isUserEnabled;
    }

    public void crearUsuario(Usuario usuario) throws Exception{
        List<Usuario> usuarios = repository.findByEmailAndIsEnabledTrue(usuario.getEmail());
        if (!usuarios.isEmpty()) {
            throw new Exception("El email ya está registrado.");
        } else {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            usuario.setEnabled(true);
            repository.save(usuario);
        }
    }




}
