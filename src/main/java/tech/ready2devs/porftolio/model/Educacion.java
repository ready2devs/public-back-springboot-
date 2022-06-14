package tech.ready2devs.porftolio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    private Long id;
    private String title;
    @Column(length=2000)
    private String detail;
    private String start;
    private String end;
    private String institution;
    private String imgEdu;


    public Educacion() {
    }

    public Educacion(Long id, String title, String detail, String start, String end, String institution, String imgEdu) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.start = start;
        this.end = end;
        this.institution = institution;
        this.imgEdu = imgEdu;
    }
}
