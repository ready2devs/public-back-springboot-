package tech.ready2devs.porftolio.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter @Setter
@Entity
public class Experiencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    private Long id;

    private String position;

    @Column(length=2000)
    private String description;

    private int start;

    private int end;

    private String organization;

    private String imgExp;


    public Experiencia() {
    }

    public Experiencia(Long id, String position, String description, int start, int end, String organization, String imgExp) {
        this.id = id;
        this.position = position;
        this.description = description;
        this.start = start;
        this.end = end;
        this.organization = organization;
        this.imgExp = imgExp;
    }

}
