package com.project.apidata.libapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MyLocation {
    @Id
    private int time;
    private double myLongitude;
    private double myLatitude;
    private int speed;

    public MyLocation() {
    }

    public MyLocation(int time, double myLongitude, double myLatitude, int speed) {
        this.time = time;
        this.myLongitude = myLongitude;
        this.myLatitude = myLatitude;
        this.speed = speed;
    }


    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getMyLongitude() {
        return myLongitude;
    }

    public void setMyLongitude(double myLongitude) {
        this.myLongitude = myLongitude;
    }

    public double getMyLatitude() {
        return myLatitude;
    }

    public void setMyLatitude(double myLatitude) {
        this.myLatitude = myLatitude;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


}
