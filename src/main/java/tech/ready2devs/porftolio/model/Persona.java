package tech.ready2devs.porftolio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter
@Entity
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, updatable = false)
    private Long id;
    private String name;
    private String surname;
    private String titleFormation;
    @Column(length=2000)
    private String about;
    private String imgProfile;


    //    Constructor void
    public Persona() {
    }

    //    Constructor parameters
    public Persona(Long id, String name, String surname, String titleFormation, String about, String imgProfile) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.titleFormation = titleFormation;
        this.about = about;
        this.imgProfile = imgProfile;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", titleFormation='" + titleFormation + '\'' +
                ", about='" + about + '\'' +
                ", imgProfile='" + imgProfile + '\'' +
                '}';
    }

}





