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
@Table(name = "course", catalog = "test", schema = "")
@NamedQueries({
    @NamedQuery(name = "Course_1.findAll", query = "SELECT c FROM Course_1 c")
    , @NamedQuery(name = "Course_1.findByCourseDbid", query = "SELECT c FROM Course_1 c WHERE c.courseDbid = :courseDbid")
    , @NamedQuery(name = "Course_1.findByCourseName", query = "SELECT c FROM Course_1 c WHERE c.courseName = :courseName")
    , @NamedQuery(name = "Course_1.findByAbbrevation", query = "SELECT c FROM Course_1 c WHERE c.abbrevation = :abbrevation")
    , @NamedQuery(name = "Course_1.findByDegreeLevel", query = "SELECT c FROM Course_1 c WHERE c.degreeLevel = :degreeLevel")})
public class Course_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "course_dbid")
    private Integer courseDbid;
    @Basic(optional = false)
    @Column(name = "CourseName")
    private String courseName;
    @Basic(optional = false)
    @Column(name = "Abbrevation")
    private String abbrevation;
    @Basic(optional = false)
    @Column(name = "DegreeLevel")
    private String degreeLevel;

    public Course_1() {
    }

    public Course_1(Integer courseDbid) {
        this.courseDbid = courseDbid;
    }

    public Course_1(Integer courseDbid, String courseName, String abbrevation, String degreeLevel) {
        this.courseDbid = courseDbid;
        this.courseName = courseName;
        this.abbrevation = abbrevation;
        this.degreeLevel = degreeLevel;
    }

    Course_1(int aInt, String string, String string0, String string1, String string2, int aInt0, int aInt1, int aInt2, int aInt3, int aInt4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getCourseDbid() {
        return courseDbid;
    }

    public void setCourseDbid(Integer courseDbid) {
        Integer oldCourseDbid = this.courseDbid;
        this.courseDbid = courseDbid;
        changeSupport.firePropertyChange("courseDbid", oldCourseDbid, courseDbid);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        String oldCourseName = this.courseName;
        this.courseName = courseName;
        changeSupport.firePropertyChange("courseName", oldCourseName, courseName);
    }

    public String getAbbrevation() {
        return abbrevation;
    }

    public void setAbbrevation(String abbrevation) {
        String oldAbbrevation = this.abbrevation;
        this.abbrevation = abbrevation;
        changeSupport.firePropertyChange("abbrevation", oldAbbrevation, abbrevation);
    }

    public String getDegreeLevel() {
        return degreeLevel;
    }

    public void setDegreeLevel(String degreeLevel) {
        String oldDegreeLevel = this.degreeLevel;
        this.degreeLevel = degreeLevel;
        changeSupport.firePropertyChange("degreeLevel", oldDegreeLevel, degreeLevel);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseDbid != null ? courseDbid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course_1)) {
            return false;
        }
        Course_1 other = (Course_1) object;
        if ((this.courseDbid == null && other.courseDbid != null) || (this.courseDbid != null && !this.courseDbid.equals(other.courseDbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "students.Course_1[ courseDbid=" + courseDbid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
