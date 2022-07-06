package com.example.ChildDayCareSpring.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Babysitter")

public class Babysitter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "First_Name")
    private String F_Name;

    @Column(name = "Last_Name")
    private String L_Name;

    @Column(name = "Babysitter_Gender")
    private String Gender;

    @Column(name = "Address")
    private String Address;

    @Column(name = "Phone")
    private String Phone;

    @Column(name = "Age")
    private int Age;

    public Babysitter() {
    }

    public Babysitter(long id, String f_Name, String l_Name, String gender, String address, String phone, int age) {
        Id = id;
        F_Name = f_Name;
        L_Name = l_Name;
        Gender = gender;
        Address = address;
        Phone = phone;
        Age = age;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getF_Name() {
        return F_Name;
    }

    public void setF_Name(String f_Name) {
        F_Name = f_Name;
    }

    public String getL_Name() {
        return L_Name;
    }

    public void setL_Name(String l_Name) {
        L_Name = l_Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    

    

}
