package aston.demospring.entity;


import javax.persistence.*;

@Entity
@Table(name="sonneur")
public class Sonneur implements Musicien{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="nomsonneur", nullable = false) /* pas obligé de renomer */
    private String nom;
    @OneToOne(targetEntity = Cornemuse.class)
    @JoinColumn(name="cornemuse_id")
    private Instrument cornemuse;

 // au choix
//    @JoinColumn
//    private Cornemuse cornemuse;

    public Sonneur() {
    }

    public Sonneur(String nom, Instrument cornemuse) {
        this.nom = nom;
        this.cornemuse = (Cornemuse) cornemuse;
    }

    public Sonneur(Long id, String nom, Instrument cornemuse) {
        this.id = id;
        this.nom = nom;
        this.cornemuse =  cornemuse;
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

    public Instrument getCornemuse() {
        return cornemuse;
    }

    public void setCornemuse(Instrument cornemuse) {
        this.cornemuse =  cornemuse;
    }

    /**
     * methode pour jouer d'un instrument
     */
    @Override
    public void jouer() {
        System.out.println(this.getNom()+" joue : "+this.getCornemuse());

    }

}
