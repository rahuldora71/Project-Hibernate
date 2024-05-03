package org.example;

import jakarta.persistence.*;

import java.sql.Blob;
import java.util.Date;
@Entity
@Table(name = "student_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;
    @Column(length = 50, name = "STREET")
    private String street;
    @Column(length = 50,name = "CITY")
    private String streetCity;
    @Column(name = "is_open")
    private boolean isOpen;
    @Transient
    private  double x;
    @Column(name = "added_date")
    @Temporal(TemporalType.DATE)
    private Date addedDate;
    @Lob
    @Column(length = 1500000)
    private byte [] image;

    public Address(int addressId, String street, String streetCity, boolean isOpen, double x, Date addedDate, byte[] image) {
        super();
        this.addressId = addressId;
        this.street = street;
        this.streetCity = streetCity;
        this.isOpen = isOpen;
        this.x = x;
        this.addedDate = addedDate;
        this.image = image;
    }

    public Address() {
        super();
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetCity() {
        return streetCity;
    }

    public void setStreetCity(String streetCity) {
        this.streetCity = streetCity;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
