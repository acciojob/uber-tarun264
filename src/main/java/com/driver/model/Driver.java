package com.driver.model;

import org.mockito.exceptions.misusing.CannotVerifyStubOnlyMock;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int driverId;
    private String mobile;
    private String Password;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    List<TripBooking> tripBookingList = new ArrayList<>();


    @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL)
    Cab cab;

    public Driver() {
    }

    public Driver(int driverId, String mobile, String password, List<TripBooking> tripBookingList, Cab cab) {
        this.driverId = driverId;
        this.mobile = mobile;
        Password = password;
        this.tripBookingList = tripBookingList;
        this.cab = cab;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public List<TripBooking> getTripBookingList() {
        return tripBookingList;
    }

    public void setTripBookingList(List<TripBooking> tripBookingList) {
        this.tripBookingList = tripBookingList;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }
}



