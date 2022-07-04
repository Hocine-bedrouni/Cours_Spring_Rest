package aston.demospring.entity;

import javax.persistence.*;


@Entity
@Table(name="pianiste")
public class Pianiste implements Musicien{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="nompianiste", nullable = false) /* pas obligé de renomer */
    private String nom;
    @OneToOne(targetEntity = Piano.class)
    @JoinColumn(name="piano_id")
    private Instrument piano;

    public Pianiste() {
    }

    public Pianiste(String nom, Instrument piano) {
        this.nom = nom;
        this.piano =  piano;
    }

    public Pianiste(Long id, String nom, Instrument piano) {
        this.id = id;
        this.nom = nom;
        this.piano =  piano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Instrument getPiano() {
        return piano;
    }

    public void setPiano(Instrument piano) {
        this.piano = piano;
    }

    /**
     * methode pour jouer d'un instrument
     */
    @Override
    public void jouer() {
        System.out.println(this.getNom()+" joue : "+this.getPiano());

    }
}
