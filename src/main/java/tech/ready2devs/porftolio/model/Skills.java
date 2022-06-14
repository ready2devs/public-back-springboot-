package tech.ready2devs.porftolio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    private Long id;
    private String nombreSkill;
    private int porcentaje;

    public Skills() {
    }

    public Skills(Long id, String nombreSkill, int porcentaje) {
        this.id = id;
        this.nombreSkill = nombreSkill;
        this.porcentaje = porcentaje;
    }

}
