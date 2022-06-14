package tech.ready2devs.porftolio.dto;

import org.springframework.util.MultiValueMap;

public class MensajeProyectos {
    private String mensajeProyectos;

    public MensajeProyectos(String mensajeProyectos) {
        this.mensajeProyectos = mensajeProyectos;
    }

    public String getMensajeProyectos() {
        return mensajeProyectos;
    }

    public void setMensaProyectos(String mensajeProyectos) {
        this.mensajeProyectos = mensajeProyectos;
    }
}