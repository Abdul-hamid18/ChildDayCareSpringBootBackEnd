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
@Table(name = "Enrollment")

public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "Child_First_Name")
    private String ch_Fname;

    @Column(name = "Child_Last_Name")
    private String ch_Lname;

    @Column(name = "Enroll_Date")
    private String enroll_Date;

    @Column(name = "Child_Gender")
    private String ch_Gender;

    @Column(name = "Parent_First_Name")
    private String pr_Fname;

    @Column(name = "Parent_Last_Name")
    private String pr_Lname;

    @Column(name = "Parent_Gender")
    private String pr_Gender;

    @Column(name = "Parent_Phone")
    private String phone;

    @Column(name = "Parent_Email")
    private String email;

    @Column(name = "Service_Category")
    private String category;

    @Column(name = "Address")
    private String address;
    
    public Enrollment() {
    }


  





    public Enrollment(long id, String ch_Fname, String ch_Lname, String enroll_Date, String ch_Gender, String pr_Fname,
            String pr_Lname, String pr_Gender, String phone, String email, String category, String address) {
        Id = id;
        this.ch_Fname = ch_Fname;
        this.ch_Lname = ch_Lname;
        this.enroll_Date = enroll_Date;
        this.ch_Gender = ch_Gender;
        this.pr_Fname = pr_Fname;
        this.pr_Lname = pr_Lname;
        this.pr_Gender = pr_Gender;
        this.phone = phone;
        this.email = email;
        this.category = category;
        this.address = address;
    }








    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public long getId() {
        return Id;
    }



    public void setId(long id) {
        Id = id;
    }

    public String getCh_Fname() {
        return ch_Fname;
    }

    public void setCh_Fname(String ch_Fname) {
        this.ch_Fname = ch_Fname;
    }

    public String getCh_Lname() {
        return ch_Lname;
    }

    public void setCh_Lname(String ch_Lname) {
        this.ch_Lname = ch_Lname;
    }

   

    public String getEnroll_Date() {
        return enroll_Date;
    }








    public void setEnroll_Date(String enroll_Date) {
        this.enroll_Date = enroll_Date;
    }








    public String getCh_Gender() {
        return ch_Gender;
    }

    public void setCh_Gender(String ch_Gender) {
        this.ch_Gender = ch_Gender;
    }

    public String getPr_Fname() {
        return pr_Fname;
    }

    public void setPr_Fname(String pr_Fname) {
        this.pr_Fname = pr_Fname;
    }

    public String getPr_Lname() {
        return pr_Lname;
    }

    public void setPr_Lname(String pr_Lname) {
        this.pr_Lname = pr_Lname;
    }

    public String getPr_Gender() {
        return pr_Gender;
    }

    public void setPr_Gender(String pr_Gender) {
        this.pr_Gender = pr_Gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
