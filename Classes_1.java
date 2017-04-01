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
@Table(name = "classes", catalog = "test", schema = "")
@NamedQueries({
    @NamedQuery(name = "Classes_1.findAll", query = "SELECT c FROM Classes_1 c")
    , @NamedQuery(name = "Classes_1.findByClassdbid", query = "SELECT c FROM Classes_1 c WHERE c.classdbid = :classdbid")
    , @NamedQuery(name = "Classes_1.findByClassName", query = "SELECT c FROM Classes_1 c WHERE c.className = :className")
    , @NamedQuery(name = "Classes_1.findByClassCapacity", query = "SELECT c FROM Classes_1 c WHERE c.classCapacity = :classCapacity")
    , @NamedQuery(name = "Classes_1.findByInstructor", query = "SELECT c FROM Classes_1 c WHERE c.instructor = :instructor")
    , @NamedQuery(name = "Classes_1.findBySection", query = "SELECT c FROM Classes_1 c WHERE c.section = :section")
    , @NamedQuery(name = "Classes_1.findByDay", query = "SELECT c FROM Classes_1 c WHERE c.day = :day")
    , @NamedQuery(name = "Classes_1.findByStart", query = "SELECT c FROM Classes_1 c WHERE c.start = :start")
    , @NamedQuery(name = "Classes_1.findByEnd", query = "SELECT c FROM Classes_1 c WHERE c.end = :end")
    , @NamedQuery(name = "Classes_1.findByUnits", query = "SELECT c FROM Classes_1 c WHERE c.units = :units")})
public class Classes_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Class_dbid")
    private Integer classdbid;
    @Basic(optional = false)
    @Column(name = "ClassName")
    private String className;
    @Basic(optional = false)
    @Column(name = "ClassCapacity")
    private int classCapacity;
    @Basic(optional = false)
    @Column(name = "Instructor")
    private String instructor;
    @Basic(optional = false)
    @Column(name = "Section")
    private String section;
    @Basic(optional = false)
    @Column(name = "Day")
    private String day;
    @Basic(optional = false)
    @Column(name = "Start")
    private String start;
    @Basic(optional = false)
    @Column(name = "End")
    private String end;
    @Basic(optional = false)
    @Column(name = "Units")
    private int units;

    public Classes_1() {
    }

    public Classes_1(Integer classdbid) {
        this.classdbid = classdbid;
    }

    public Classes_1(Integer classdbid, String className, int classCapacity, String instructor, String section, String day, String start, String end, int units) {
        this.classdbid = classdbid;
        this.className = className;
        this.classCapacity = classCapacity;
        this.instructor = instructor;
        this.section = section;
        this.day = day;
        this.start = start;
        this.end = end;
        this.units = units;
    }

    public Integer getClassdbid() {
        return classdbid;
    }

    public void setClassdbid(Integer classdbid) {
        Integer oldClassdbid = this.classdbid;
        this.classdbid = classdbid;
        changeSupport.firePropertyChange("classdbid", oldClassdbid, classdbid);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        String oldClassName = this.className;
        this.className = className;
        changeSupport.firePropertyChange("className", oldClassName, className);
    }

    public int getClassCapacity() {
        return classCapacity;
    }

    public void setClassCapacity(int classCapacity) {
        int oldClassCapacity = this.classCapacity;
        this.classCapacity = classCapacity;
        changeSupport.firePropertyChange("classCapacity", oldClassCapacity, classCapacity);
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        String oldInstructor = this.instructor;
        this.instructor = instructor;
        changeSupport.firePropertyChange("instructor", oldInstructor, instructor);
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        String oldSection = this.section;
        this.section = section;
        changeSupport.firePropertyChange("section", oldSection, section);
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        String oldDay = this.day;
        this.day = day;
        changeSupport.firePropertyChange("day", oldDay, day);
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        String oldStart = this.start;
        this.start = start;
        changeSupport.firePropertyChange("start", oldStart, start);
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        String oldEnd = this.end;
        this.end = end;
        changeSupport.firePropertyChange("end", oldEnd, end);
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        int oldUnits = this.units;
        this.units = units;
        changeSupport.firePropertyChange("units", oldUnits, units);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classdbid != null ? classdbid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classes_1)) {
            return false;
        }
        Classes_1 other = (Classes_1) object;
        if ((this.classdbid == null && other.classdbid != null) || (this.classdbid != null && !this.classdbid.equals(other.classdbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "students.Classes_1[ classdbid=" + classdbid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
