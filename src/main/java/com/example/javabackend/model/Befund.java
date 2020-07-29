package com.example.javabackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "befund")
public class Befund {

    @Id
    @GeneratedValue (strategy= GenerationType.AUTO)
    private Long id;

    private Date erhobenAm;
    private String beschreibung;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "baum_id", nullable = false)
    private Baum baum;

    protected Befund() {}

    public Befund(Date erhobenAm, String beschreibung, Baum baum) {
        this.erhobenAm = erhobenAm;
        this.beschreibung = beschreibung;
        this.baum = baum;
    }

    public Date getErhobenAm() {
        return erhobenAm;
    }

    public void setErhobenAm(Date erhobenAm) {
        this.erhobenAm = erhobenAm;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}
