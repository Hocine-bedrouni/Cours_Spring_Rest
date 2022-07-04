package aston.demospring.entity;


import javax.persistence.*;

/**
 * Classe Piano qui implement l'interface Instrument
 */
@Entity
@Table(name="piano")
public class Piano implements Instrument{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="modelpiano", nullable = false) /* pas obligé de renomer */
    private String model;

    public Piano() {
    }

    public Piano(Long id, String model) {
        this.id = id;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

