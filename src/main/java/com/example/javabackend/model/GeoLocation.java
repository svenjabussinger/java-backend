package com.example.javabackend.model;

import javax.persistence.*;

@Entity
@Table(name="geolocation")
public class GeoLocation {

    @Id
    @GeneratedValue (strategy= GenerationType.AUTO)
    private Long id;

    private double latitude;
    private double longitude;

    @OneToOne(mappedBy = "geolocation", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Baum baum;

    protected GeoLocation() {}

    public GeoLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
