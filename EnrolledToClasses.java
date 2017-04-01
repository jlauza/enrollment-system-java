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
@Table(name = "enrolled_to_classes", catalog = "test", schema = "")
@NamedQueries({
    @NamedQuery(name = "EnrolledToClasses.findAll", query = "SELECT e FROM EnrolledToClasses e")
    , @NamedQuery(name = "EnrolledToClasses.findByEcId", query = "SELECT e FROM EnrolledToClasses e WHERE e.ecId = :ecId")
    , @NamedQuery(name = "EnrolledToClasses.findByClassDetails", query = "SELECT e FROM EnrolledToClasses e WHERE e.classDetails = :classDetails")
    , @NamedQuery(name = "EnrolledToClasses.findByFirstname", query = "SELECT e FROM EnrolledToClasses e WHERE e.firstname = :firstname")
    , @NamedQuery(name = "EnrolledToClasses.findByLastname", query = "SELECT e FROM EnrolledToClasses e WHERE e.lastname = :lastname")
    , @NamedQuery(name = "EnrolledToClasses.findByStudentDbid", query = "SELECT e FROM EnrolledToClasses e WHERE e.studentDbid = :studentDbid")
    , @NamedQuery(name = "EnrolledToClasses.findByClassdbid", query = "SELECT e FROM EnrolledToClasses e WHERE e.classdbid = :classdbid")})
public class EnrolledToClasses implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ec_id")
    private Integer ecId;
    @Basic(optional = false)
    @Column(name = "ClassDetails")
    private String classDetails;
    @Basic(optional = false)
    @Column(name = "Firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "Lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "student_dbid")
    private int studentDbid;
    @Basic(optional = false)
    @Column(name = "Class_dbid")
    private int classdbid;

    public EnrolledToClasses() {
    }

    public EnrolledToClasses(Integer ecId) {
        this.ecId = ecId;
    }

    public EnrolledToClasses(Integer ecId, String classDetails, String firstname, String lastname, int studentDbid, int classdbid) {
        this.ecId = ecId;
        this.classDetails = classDetails;
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentDbid = studentDbid;
        this.classdbid = classdbid;
    }

    EnrolledToClasses(int aInt, String string, String string0, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getEcId() {
        return ecId;
    }

    public void setEcId(Integer ecId) {
        Integer oldEcId = this.ecId;
        this.ecId = ecId;
        changeSupport.firePropertyChange("ecId", oldEcId, ecId);
    }

    public String getClassDetails() {
        return classDetails;
    }

    public void setClassDetails(String classDetails) {
        String oldClassDetails = this.classDetails;
        this.classDetails = classDetails;
        changeSupport.firePropertyChange("classDetails", oldClassDetails, classDetails);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        String oldFirstname = this.firstname;
        this.firstname = firstname;
        changeSupport.firePropertyChange("firstname", oldFirstname, firstname);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        String oldLastname = this.lastname;
        this.lastname = lastname;
        changeSupport.firePropertyChange("lastname", oldLastname, lastname);
    }

    public int getStudentDbid() {
        return studentDbid;
    }

    public void setStudentDbid(int studentDbid) {
        int oldStudentDbid = this.studentDbid;
        this.studentDbid = studentDbid;
        changeSupport.firePropertyChange("studentDbid", oldStudentDbid, studentDbid);
    }

    public int getClassdbid() {
        return classdbid;
    }

    public void setClassdbid(int classdbid) {
        int oldClassdbid = this.classdbid;
        this.classdbid = classdbid;
        changeSupport.firePropertyChange("classdbid", oldClassdbid, classdbid);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ecId != null ? ecId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnrolledToClasses)) {
            return false;
        }
        EnrolledToClasses other = (EnrolledToClasses) object;
        if ((this.ecId == null && other.ecId != null) || (this.ecId != null && !this.ecId.equals(other.ecId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "students.EnrolledToClasses[ ecId=" + ecId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
