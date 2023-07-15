package com.driver.model;

import jdk.dynalink.linker.LinkerServices;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    private String mobileNO;
    private String password;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<TripBooking> tripBookingList= new ArrayList<>();

    public Customer() {
    }

    public Customer(int customerId, String mobileNO, String password, List<TripBooking> tripBookingList) {
        this.customerId = customerId;
        this.mobileNO = mobileNO;
        this.password = password;
        this.tripBookingList = tripBookingList;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getMobileNO() {
        return mobileNO;
    }

    public void setMobileNO(String mobileNO) {
        this.mobileNO = mobileNO;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TripBooking> getTripBookingList() {
        return tripBookingList;
    }

    public void setTripBookingList(List<TripBooking> tripBookingList) {
        this.tripBookingList = tripBookingList;
    }
}