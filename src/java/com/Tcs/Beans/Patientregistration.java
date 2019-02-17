/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Tcs.Beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 1528110
 */
@Entity
@Table(name = "Patient_registration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patientregistration.findAll", query = "SELECT p FROM Patientregistration p")
    , @NamedQuery(name = "Patientregistration.findByPatientName", query = "SELECT p FROM Patientregistration p WHERE p.patientName = :patientName")
    , @NamedQuery(name = "Patientregistration.findByPatientID", query = "SELECT p FROM Patientregistration p WHERE p.patientID = :patientID")
    , @NamedQuery(name = "Patientregistration.findByAge", query = "SELECT p FROM Patientregistration p WHERE p.age = :age")
    , @NamedQuery(name = "Patientregistration.findByGender", query = "SELECT p FROM Patientregistration p WHERE p.gender = :gender")
    , @NamedQuery(name = "Patientregistration.findByAddress", query = "SELECT p FROM Patientregistration p WHERE p.address = :address")
    , @NamedQuery(name = "Patientregistration.findByIdentifier", query = "SELECT p FROM Patientregistration p WHERE p.identifier = :identifier")
    , @NamedQuery(name = "Patientregistration.findByAllergies", query = "SELECT p FROM Patientregistration p WHERE p.allergies = :allergies")
    , @NamedQuery(name = "Patientregistration.findByZipcode", query = "SELECT p FROM Patientregistration p WHERE p.zipcode = :zipcode")
    , @NamedQuery(name = "Patientregistration.findByComorbidities", query = "SELECT p FROM Patientregistration p WHERE p.comorbidities = :comorbidities")})
public class Patientregistration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Patient_Name")
    private String patientName;

    @Id
    @Basic(optional = false)
    @Column(name = "Patient_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer patientID;

    @Basic(optional = false)
    @Column(name = "Age")
    private int age;
    @Basic(optional = false)
    @Column(name = "Gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @Column(name = "Identifier")
    private String identifier;
    @Column(name = "Allergies")
    private String allergies;
    @Basic(optional = false)
    @Column(name = "Zip_code")
    private int zipcode;
    @Column(name = "Comorbidities")
    private String comorbidities;

    public Patientregistration() {
    }

    public Patientregistration(Integer patientID) {
        this.patientID = patientID;
    }

    public Patientregistration(Integer patientID, String patientName, int age, String gender, String address, String identifier, int zipcode) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.identifier = identifier;
        this.zipcode = zipcode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getComorbidities() {
        return comorbidities;
    }

    public void setComorbidities(String comorbidities) {
        this.comorbidities = comorbidities;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientID != null ? patientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patientregistration)) {
            return false;
        }
        Patientregistration other = (Patientregistration) object;
        if ((this.patientID == null && other.patientID != null) || (this.patientID != null && !this.patientID.equals(other.patientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Tcs.Beans.Patientregistration[ patientID=" + patientID + " ]";
    }

}
