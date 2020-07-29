package com.example.javabackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="stadt")
public class Stadt {

    @Id
    @GeneratedValue (strategy= GenerationType.AUTO)
    private Long id;

    private String plz;
    private String name;

    @OneToMany(mappedBy = "stadt", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Strasse> strasse;

    protected Stadt() {}

    public Stadt(String plz, String name) {
        this.plz = plz;
        this.name = name;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
