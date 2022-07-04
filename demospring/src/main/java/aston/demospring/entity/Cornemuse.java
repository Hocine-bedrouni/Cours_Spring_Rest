package aston.demospring.entity;


import javax.persistence.*;

@Entity
@Table(name="cornemuse")
public class Cornemuse implements Instrument{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="modelcornemuse", nullable = false) /* pas obligé de renomer */
    private String model;

    public Cornemuse(Long id, String model) {
        this.id = id;
        this.model = model;
    }

    public Cornemuse() {
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

    public String toString() {
        return " lalalalala";
    }
}

