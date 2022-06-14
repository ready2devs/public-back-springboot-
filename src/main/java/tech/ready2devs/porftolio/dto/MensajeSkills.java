package tech.ready2devs.porftolio.dto;

import org.springframework.util.MultiValueMap;

public class MensajeSkills {
    private String mensajeSkills;

    public MensajeSkills(String mensajeSkills) {
        this.mensajeSkills = mensajeSkills;
    }

    public String getMensajeSkills() {
        return mensajeSkills;
    }

    public void setMensajeSkills(String mensajeSkills) {
        this.mensajeSkills = mensajeSkills;
    }
}
