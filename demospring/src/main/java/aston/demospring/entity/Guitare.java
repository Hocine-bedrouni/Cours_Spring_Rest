package aston.demospring.entity;


import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Classe guitare qui implement instrument
 */

@Entity
@Table(name="guitare")
public class Guitare implements Instrument{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="modelguitare", nullable = false) /* pas obligé de renomer */
    private String model;

    public Guitare(Long id, String model) {
        this.id = id;
        this.model = model;
    }



    public Guitare(String model) {
        this.model = model;
    }

    public Guitare() {
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
        return "glink glink glink";
    }
}


