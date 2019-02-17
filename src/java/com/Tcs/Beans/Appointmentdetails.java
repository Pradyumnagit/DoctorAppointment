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
@Table(name = "Appointment_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appointmentdetails.findAll", query = "SELECT a FROM Appointmentdetails a")
    , @NamedQuery(name = "Appointmentdetails.findByPatientID", query = "SELECT a FROM Appointmentdetails a WHERE a.patientID = :patientID")
    , @NamedQuery(name = "Appointmentdetails.findByPatientname", query = "SELECT a FROM Appointmentdetails a WHERE a.patientname = :patientname")
    , @NamedQuery(name = "Appointmentdetails.findByAge", query = "SELECT a FROM Appointmentdetails a WHERE a.age = :age")
    , @NamedQuery(name = "Appointmentdetails.findByGender", query = "SELECT a FROM Appointmentdetails a WHERE a.gender = :gender")
    , @NamedQuery(name = "Appointmentdetails.findByPConsultant", query = "SELECT a FROM Appointmentdetails a WHERE a.pConsultant = :pConsultant")
    , @NamedQuery(name = "Appointmentdetails.findBySConsultant", query = "SELECT a FROM Appointmentdetails a WHERE a.sConsultant = :sConsultant")
    , @NamedQuery(name = "Appointmentdetails.findByDatetime", query = "SELECT a FROM Appointmentdetails a WHERE a.datetime = :datetime")})
public class Appointmentdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Patient_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientID;
    @Column(name = "Patient_name")
    private String patientname;
    @Basic(optional = false)
    @Column(name = "Age")
    private int age;
    @Basic(optional = false)
    @Column(name = "Gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "P_Consultant")
    private String pConsultant;
    @Column(name = "S_Consultant")
    private String sConsultant;
    @Basic(optional = false)
    @Column(name = "Date_time")
    private String datetime;

    public Appointmentdetails() {
    }

    public Appointmentdetails(Integer patientID) {
        this.patientID = patientID;
    }

    public Appointmentdetails(Integer patientID, int age, String gender, String pConsultant, String datetime) {
        this.patientID = patientID;
        this.age = age;
        this.gender = gender;
        this.pConsultant = pConsultant;
        this.datetime = datetime;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
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

    public String getPConsultant() {
        return pConsultant;
    }

    public void setPConsultant(String pConsultant) {
        this.pConsultant = pConsultant;
    }

    public String getSConsultant() {
        return sConsultant;
    }

    public void setSConsultant(String sConsultant) {
        this.sConsultant = sConsultant;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
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
        if (!(object instanceof Appointmentdetails)) {
            return false;
        }
        Appointmentdetails other = (Appointmentdetails) object;
        if ((this.patientID == null && other.patientID != null) || (this.patientID != null && !this.patientID.equals(other.patientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Tcs.Beans.Appointmentdetails[ patientID=" + patientID + " ]";
    }

}
