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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 1528178
 */
@Entity
@Table(name = "images")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Images.findAll", query = "SELECT i FROM Images i")
    , @NamedQuery(name = "Images.findByPatName", query = "SELECT i FROM Images i WHERE i.patName = :patName")
    , @NamedQuery(name = "Images.findByPatId", query = "SELECT i FROM Images i WHERE i.patId = :patId")})
public class Images implements Serializable {

    private static final long serialVersionUID = 1L;
    @Lob
    @Column(name = "pat_image")
    private byte[] patImage;
    @Column(name = "pat_name")
    private String patName;
    @Id
    @Basic(optional = false)
    @Column(name = "pat_id")
    private Short patId;
    @Lob
    @Column(name = "pat_image2")
    private byte[] patImage2;
    @Lob
    @Column(name = "pat_image3")
    private byte[] patImage3;
    @Lob
    @Column(name = "pat_image4")
    private byte[] patImage4;
    @Lob
    @Column(name = "pat_image5")
    private byte[] patImage5;

    public Images() {
    }

    public Images(Short patId) {
        this.patId = patId;
    }

    public byte[] getPatImage() {
        return patImage;
    }

    public void setPatImage(byte[] patImage) {
        this.patImage = patImage;
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

    public Short getPatId() {
        return patId;
    }

    public void setPatId(Short patId) {
        this.patId = patId;
    }

    public byte[] getPatImage2() {
        return patImage2;
    }

    public void setPatImage2(byte[] patImage2) {
        this.patImage2 = patImage2;
    }

    public byte[] getPatImage3() {
        return patImage3;
    }

    public void setPatImage3(byte[] patImage3) {
        this.patImage3 = patImage3;
    }

    public byte[] getPatImage4() {
        return patImage4;
    }

    public void setPatImage4(byte[] patImage4) {
        this.patImage4 = patImage4;
    }

    public byte[] getPatImage5() {
        return patImage5;
    }

    public void setPatImage5(byte[] patImage5) {
        this.patImage5 = patImage5;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patId != null ? patId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Images)) {
            return false;
        }
        Images other = (Images) object;
        if ((this.patId == null && other.patId != null) || (this.patId != null && !this.patId.equals(other.patId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Tcs.Beans.Images[ patId=" + patId + " ]";
    }
    
}
