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
@Table(name = "ratings", catalog = "test", schema = "")
@NamedQueries({
    @NamedQuery(name = "Ratings.findAll", query = "SELECT r FROM Ratings r")
    , @NamedQuery(name = "Ratings.findByRatingsdbid", query = "SELECT r FROM Ratings r WHERE r.ratingsdbid = :ratingsdbid")
    , @NamedQuery(name = "Ratings.findByFirstname", query = "SELECT r FROM Ratings r WHERE r.firstname = :firstname")
    , @NamedQuery(name = "Ratings.findByLastname", query = "SELECT r FROM Ratings r WHERE r.lastname = :lastname")
    , @NamedQuery(name = "Ratings.findByClassName", query = "SELECT r FROM Ratings r WHERE r.className = :className")
    , @NamedQuery(name = "Ratings.findBySemester", query = "SELECT r FROM Ratings r WHERE r.semester = :semester")
    , @NamedQuery(name = "Ratings.findByPrelim", query = "SELECT r FROM Ratings r WHERE r.prelim = :prelim")
    , @NamedQuery(name = "Ratings.findByMidterm", query = "SELECT r FROM Ratings r WHERE r.midterm = :midterm")
    , @NamedQuery(name = "Ratings.findByPrefinal", query = "SELECT r FROM Ratings r WHERE r.prefinal = :prefinal")
    , @NamedQuery(name = "Ratings.findByFinal1", query = "SELECT r FROM Ratings r WHERE r.final1 = :final1")
    , @NamedQuery(name = "Ratings.findByOverallRating", query = "SELECT r FROM Ratings r WHERE r.overallRating = :overallRating")})
public class Ratings implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Ratings_dbid")
    private Integer ratingsdbid;
    @Basic(optional = false)
    @Column(name = "Firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "Lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "ClassName")
    private String className;
    @Basic(optional = false)
    @Column(name = "Semester")
    private String semester;
    @Basic(optional = false)
    @Column(name = "Prelim")
    private int prelim;
    @Basic(optional = false)
    @Column(name = "Midterm")
    private int midterm;
    @Basic(optional = false)
    @Column(name = "Prefinal")
    private int prefinal;
    @Basic(optional = false)
    @Column(name = "Final")
    private int final1;
    @Basic(optional = false)
    @Column(name = "OverallRating")
    private int overallRating;

    public Ratings() {
    }

    public Ratings(Integer ratingsdbid) {
        this.ratingsdbid = ratingsdbid;
    }

    public Ratings(Integer ratingsdbid, String firstname, String lastname, String className, String semester, int prelim, int midterm, int prefinal, int final1, int overallRating) {
        this.ratingsdbid = ratingsdbid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.className = className;
        this.semester = semester;
        this.prelim = prelim;
        this.midterm = midterm;
        this.prefinal = prefinal;
        this.final1 = final1;
        this.overallRating = overallRating;
    }

    public Integer getRatingsdbid() {
        return ratingsdbid;
    }

    public void setRatingsdbid(Integer ratingsdbid) {
        Integer oldRatingsdbid = this.ratingsdbid;
        this.ratingsdbid = ratingsdbid;
        changeSupport.firePropertyChange("ratingsdbid", oldRatingsdbid, ratingsdbid);
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        String oldClassName = this.className;
        this.className = className;
        changeSupport.firePropertyChange("className", oldClassName, className);
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        String oldSemester = this.semester;
        this.semester = semester;
        changeSupport.firePropertyChange("semester", oldSemester, semester);
    }

    public int getPrelim() {
        return prelim;
    }

    public void setPrelim(int prelim) {
        int oldPrelim = this.prelim;
        this.prelim = prelim;
        changeSupport.firePropertyChange("prelim", oldPrelim, prelim);
    }

    public int getMidterm() {
        return midterm;
    }

    public void setMidterm(int midterm) {
        int oldMidterm = this.midterm;
        this.midterm = midterm;
        changeSupport.firePropertyChange("midterm", oldMidterm, midterm);
    }

    public int getPrefinal() {
        return prefinal;
    }

    public void setPrefinal(int prefinal) {
        int oldPrefinal = this.prefinal;
        this.prefinal = prefinal;
        changeSupport.firePropertyChange("prefinal", oldPrefinal, prefinal);
    }

    public int getFinal1() {
        return final1;
    }

    public void setFinal1(int final1) {
        int oldFinal1 = this.final1;
        this.final1 = final1;
        changeSupport.firePropertyChange("final1", oldFinal1, final1);
    }

    public int getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(int overallRating) {
        int oldOverallRating = this.overallRating;
        this.overallRating = overallRating;
        changeSupport.firePropertyChange("overallRating", oldOverallRating, overallRating);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ratingsdbid != null ? ratingsdbid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ratings)) {
            return false;
        }
        Ratings other = (Ratings) object;
        if ((this.ratingsdbid == null && other.ratingsdbid != null) || (this.ratingsdbid != null && !this.ratingsdbid.equals(other.ratingsdbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "students.Ratings[ ratingsdbid=" + ratingsdbid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
