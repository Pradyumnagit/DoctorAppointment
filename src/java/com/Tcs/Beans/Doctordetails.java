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
@Table(name = "Doctor_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctordetails.findAll", query = "SELECT d FROM Doctordetails d")
    , @NamedQuery(name = "Doctordetails.findByDoctorname", query = "SELECT d FROM Doctordetails d WHERE d.doctorname = :doctorname")
    , @NamedQuery(name = "Doctordetails.findByDoctorId", query = "SELECT d FROM Doctordetails d WHERE d.doctorId = :doctorId")
    , @NamedQuery(name = "Doctordetails.findByDepartment", query = "SELECT d FROM Doctordetails d WHERE d.department = :department")})
public class Doctordetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Doctor_name")
    private String doctorname;
    @Id
    @Basic(optional = false)
    @Column(name = "doctor_id")
    private Integer doctorId;
    @Basic(optional = false)
    @Column(name = "Department")
    private String department;

    public Doctordetails() {
    }

    public Doctordetails(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Doctordetails(Integer doctorId, String doctorname, String department) {
        this.doctorId = doctorId;
        this.doctorname = doctorname;
        this.department = department;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorId != null ? doctorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctordetails)) {
            return false;
        }
        Doctordetails other = (Doctordetails) object;
        if ((this.doctorId == null && other.doctorId != null) || (this.doctorId != null && !this.doctorId.equals(other.doctorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Tcs.Beans.Doctordetails[ doctorId=" + doctorId + " ]";
    }
    
}
