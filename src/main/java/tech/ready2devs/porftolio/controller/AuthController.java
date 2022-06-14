package tech.ready2devs.porftolio.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.ready2devs.porftolio.dto.UserDto;
import tech.ready2devs.porftolio.model.Usuario;
import tech.ready2devs.porftolio.service.AuthService;

import java.util.List;

@RestController
public class AuthController {

    @Autowired
    AuthService service;

    @GetMapping("/usuarios")
    @ResponseBody
    public List<Usuario> verUsuarios(){
        return service.findAllUsuarios();
    }

    @PostMapping("/login")
    public boolean login(@RequestBody UserDto userDto) {
        return service.isUserEnabled(userDto);
    }

    @PostMapping("/register")
    public void register(@RequestBody Usuario usuario) throws Exception {
        service.crearUsuario(usuario);
    }

}
