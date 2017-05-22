package br.com.concretesolutions.earthquakeapp.data;

import java.util.Date;

/**
 * Created by douglasmotta on 22/05/17.
 */

public class Earthquake {
    private Double magnitude;
    private String location;
    private Date date;

    public Earthquake(Double magnitude, String location, Date date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Double magnitude) {
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "magnitude=" + magnitude +
                ", location='" + location + '\'' +
                ", date=" + date +
                '}';
    }
}
