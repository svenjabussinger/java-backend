package com.example.javabackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="strasse")
public class Strasse {

    @Id
    @GeneratedValue (strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String verwaltungsKuerzel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "stadt_id", nullable = false)
    private Stadt stadt;

    @OneToMany(mappedBy = "strasse", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Baum> baume;

    protected Strasse() {}

    public Strasse(String name, String verwaltungsKuerzel, Stadt stadt) {
        this.name = name;
        this.verwaltungsKuerzel = verwaltungsKuerzel;
        this.stadt = stadt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVerwaltungsKuerzel() {
        return verwaltungsKuerzel;
    }

    public void setVerwaltungsKuerzel(String verwaltungsKuerzel) {
        this.verwaltungsKuerzel = verwaltungsKuerzel;
    }
}
