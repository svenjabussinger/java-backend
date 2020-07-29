package com.example.javabackend.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="baum")
public class Baum {

    @Id
    @GeneratedValue (strategy= GenerationType.AUTO)
    private Long id;

    private long nummer;
    private Date pflanzdatum;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "strasse_id", nullable = false)
    private Strasse strasse;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "spezies_id", nullable = false)
    private Spezies spezies;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "geolocation_id", nullable = false)
    private GeoLocation geolocation;

    @OneToMany(mappedBy = "baum", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Befund> befund;

    protected Baum() {}

    public Baum(long nummer, Date pflanzdatum, Strasse strasse, Spezies spezies, GeoLocation geolocation) {
        this.nummer = nummer;
        this.pflanzdatum = pflanzdatum;
        this.strasse = strasse;
        this.spezies = spezies;
        this.geolocation = geolocation;
    }

    public long getNummer() {
        return nummer;
    }

    public void setNummer(long nummer) {
        this.nummer = nummer;
    }

    public Date getPflanzdatum() {
        return pflanzdatum;
    }

    public void setPflanzdatum(Date pflanzdatum) {
        this.pflanzdatum = pflanzdatum;
    }
}
