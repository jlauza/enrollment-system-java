/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;

/**
 *
 * @author jayson
 */
@Entity
@Table(name = "instructors", catalog = "test", schema = "")
@NamedQueries({
    @NamedQuery(name = "Instructors.findAll", query = "SELECT i FROM Instructors i")
    , @NamedQuery(name = "Instructors.findByInstructordbid", query = "SELECT i FROM Instructors i WHERE i.instructordbid = :instructordbid")
    , @NamedQuery(name = "Instructors.findByInstructorID", query = "SELECT i FROM Instructors i WHERE i.instructorID = :instructorID")
    , @NamedQuery(name = "Instructors.findByFirstname", query = "SELECT i FROM Instructors i WHERE i.firstname = :firstname")
    , @NamedQuery(name = "Instructors.findByMiddlename", query = "SELECT i FROM Instructors i WHERE i.middlename = :middlename")
    , @NamedQuery(name = "Instructors.findByLastname", query = "SELECT i FROM Instructors i WHERE i.lastname = :lastname")
    , @NamedQuery(name = "Instructors.findByGender", query = "SELECT i FROM Instructors i WHERE i.gender = :gender")
    , @NamedQuery(name = "Instructors.findByEmail", query = "SELECT i FROM Instructors i WHERE i.email = :email")})
public class Instructors implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Instructor_dbid")
    private Integer instructordbid;
    @Basic(optional = false)
    @Column(name = "InstructorID")
    private int instructorID;
    @Basic(optional = false)
    @Column(name = "Firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "Middlename")
    private String middlename;
    @Basic(optional = false)
    @Column(name = "Lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "Gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;

    public Instructors() {
    }

    public Instructors(Integer instructordbid) {
        this.instructordbid = instructordbid;
    }

    public Instructors(Integer instructordbid, int instructorID, String firstname, String middlename, String lastname, String gender, String email) {
        this.instructordbid = instructordbid;
        this.instructorID = instructorID;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.gender = gender;
        this.email = email;
    }

    public Integer getInstructordbid() {
        return instructordbid;
    }

    public void setInstructordbid(Integer instructordbid) {
        Integer oldInstructordbid = this.instructordbid;
        this.instructordbid = instructordbid;
        changeSupport.firePropertyChange("instructordbid", oldInstructordbid, instructordbid);
    }

    public int getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(int instructorID) {
        int oldInstructorID = this.instructorID;
        this.instructorID = instructorID;
        changeSupport.firePropertyChange("instructorID", oldInstructorID, instructorID);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        String oldFirstname = this.firstname;
        this.firstname = firstname;
        changeSupport.firePropertyChange("firstname", oldFirstname, firstname);
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        String oldMiddlename = this.middlename;
        this.middlename = middlename;
        changeSupport.firePropertyChange("middlename", oldMiddlename, middlename);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        String oldLastname = this.lastname;
        this.lastname = lastname;
        changeSupport.firePropertyChange("lastname", oldLastname, lastname);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        String oldGender = this.gender;
        this.gender = gender;
        changeSupport.firePropertyChange("gender", oldGender, gender);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instructordbid != null ? instructordbid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructors)) {
            return false;
        }
        Instructors other = (Instructors) object;
        if ((this.instructordbid == null && other.instructordbid != null) || (this.instructordbid != null && !this.instructordbid.equals(other.instructordbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "students.Instructors[ instructordbid=" + instructordbid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
