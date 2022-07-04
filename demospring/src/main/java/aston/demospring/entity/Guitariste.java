package aston.demospring.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Classe Guitariste qui implement Musicien
 */


@Entity
@Table(name="guitariste")
public class Guitariste implements Musicien{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //    @NotNull facultatif puisque nullable = false
    @Column(name="nomguitariste", nullable = false) /* pas obligé de renomer */
    @Size(max=50) /* taille du chant en caractère */
    private String nom;

    @OneToOne(targetEntity = Guitare.class)
    @JoinColumn(name="guitare_id")
    private Instrument guitare;

    public Guitariste() {
    }

    public Guitariste(String nom, Instrument guitare) {
        this.nom = nom;
        this.guitare = guitare;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Instrument getGuitare() {
        return guitare;
    }

    public void setGuitare(Instrument guitare) {
        this.guitare = guitare;
    }

    public Guitariste(Long id, String nom, Instrument guitare) {
        this.id = id;
        this.nom = nom;
        this.guitare = guitare;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * methode pour jouer d'un instrument
     */
    @Override
    public void jouer() {
        System.out.println(this.getNom()+" joue : "+this.getGuitare());

    }
}
