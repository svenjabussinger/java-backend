package com.example.javabackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="spezies")
public class Spezies {

    @Id
    @GeneratedValue (strategy= GenerationType.AUTO)
    private Long id;

    private String botanischerName;
    private String trivialName;

    @OneToMany(mappedBy = "spezies", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Baum> baum;

    protected Spezies() {}

    public Spezies(String botanischerName, String trivialName) {
        this.botanischerName = botanischerName;
        this.trivialName = trivialName;
    }

    public String getBotanischerName() {
        return botanischerName;
    }

    public void setBotanischerName(String botanischerName) {
        this.botanischerName = botanischerName;
    }

    public String getTrivialName() {
        return trivialName;
    }

    public void setTrivialName(String trivialName) {
        this.trivialName = trivialName;
    }
}
