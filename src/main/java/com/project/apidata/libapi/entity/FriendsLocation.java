package com.project.apidata.libapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FriendsLocation {
    @Id
    private int friendId;
    private String friend;
    private double friendLongitude;
    private double friendLatitude;


    public FriendsLocation(int friendId, String friend, double friendLongitude, double friendLatitude) {
        this.friendId = friendId;
        this.friend = friend;
        this.friendLongitude = friendLongitude;
        this.friendLatitude = friendLatitude;
    }

    public FriendsLocation() {
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public double getFriendLongitude() {
        return friendLongitude;
    }

    public void setFriendLongitude(double friendLongitude) {
        this.friendLongitude = friendLongitude;
    }

    public double getFriendLatitude() {
        return friendLatitude;
    }

    public void setFriendLatitude(double friendLatitude) {
        this.friendLatitude = friendLatitude;
    }


}
