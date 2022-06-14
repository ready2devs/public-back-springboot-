package tech.ready2devs.porftolio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Proyectos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length=2000)
    private String detail;
    private String start;
    private String end;
    private String imgProyecto;

    public Proyectos() {
    }

    public Proyectos(Long id, String title, String detail, String start, String end, String imgProyecto) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.start = start;
        this.end = end;
        this.imgProyecto = imgProyecto;
    }
}
