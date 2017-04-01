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
@Table(name = "student_info", catalog = "test", schema = "")
@NamedQueries({
    @NamedQuery(name = "StudentInfo.findAll", query = "SELECT s FROM StudentInfo s")
    , @NamedQuery(name = "StudentInfo.findByStudentDbid", query = "SELECT s FROM StudentInfo s WHERE s.studentDbid = :studentDbid")
    , @NamedQuery(name = "StudentInfo.findByStudentID", query = "SELECT s FROM StudentInfo s WHERE s.studentID = :studentID")
    , @NamedQuery(name = "StudentInfo.findByFirstname", query = "SELECT s FROM StudentInfo s WHERE s.firstname = :firstname")
    , @NamedQuery(name = "StudentInfo.findByMiddlename", query = "SELECT s FROM StudentInfo s WHERE s.middlename = :middlename")
    , @NamedQuery(name = "StudentInfo.findByLastname", query = "SELECT s FROM StudentInfo s WHERE s.lastname = :lastname")
    , @NamedQuery(name = "StudentInfo.findByAge", query = "SELECT s FROM StudentInfo s WHERE s.age = :age")
    , @NamedQuery(name = "StudentInfo.findByGender", query = "SELECT s FROM StudentInfo s WHERE s.gender = :gender")
    , @NamedQuery(name = "StudentInfo.findByCourse", query = "SELECT s FROM StudentInfo s WHERE s.course = :course")
    , @NamedQuery(name = "StudentInfo.findByYearLevel", query = "SELECT s FROM StudentInfo s WHERE s.yearLevel = :yearLevel")
    , @NamedQuery(name = "StudentInfo.findByEmail", query = "SELECT s FROM StudentInfo s WHERE s.email = :email")})
public class StudentInfo implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "student_dbid")
    private Integer studentDbid;
    @Basic(optional = false)
    @Column(name = "StudentID")
    private String studentID;
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
    @Column(name = "Age")
    private int age;
    @Basic(optional = false)
    @Column(name = "Gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "Course")
    private String course;
    @Basic(optional = false)
    @Column(name = "YearLevel")
    private String yearLevel;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;

    public StudentInfo() {
    }

    public StudentInfo(Integer studentDbid) {
        this.studentDbid = studentDbid;
    }

    public StudentInfo(Integer studentDbid, String studentID, String firstname, String middlename, String lastname, int age, String gender, String course, String yearLevel, String email) {
        this.studentDbid = studentDbid;
        this.studentID = studentID;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.course = course;
        this.yearLevel = yearLevel;
        this.email = email;
    }

    public Integer getStudentDbid() {
        return studentDbid;
    }

    public void setStudentDbid(Integer studentDbid) {
        Integer oldStudentDbid = this.studentDbid;
        this.studentDbid = studentDbid;
        changeSupport.firePropertyChange("studentDbid", oldStudentDbid, studentDbid);
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        String oldStudentID = this.studentID;
        this.studentID = studentID;
        changeSupport.firePropertyChange("studentID", oldStudentID, studentID);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        int oldAge = this.age;
        this.age = age;
        changeSupport.firePropertyChange("age", oldAge, age);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        String oldGender = this.gender;
        this.gender = gender;
        changeSupport.firePropertyChange("gender", oldGender, gender);
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        String oldCourse = this.course;
        this.course = course;
        changeSupport.firePropertyChange("course", oldCourse, course);
    }

    public String getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(String yearLevel) {
        String oldYearLevel = this.yearLevel;
        this.yearLevel = yearLevel;
        changeSupport.firePropertyChange("yearLevel", oldYearLevel, yearLevel);
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
        hash += (studentDbid != null ? studentDbid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentInfo)) {
            return false;
        }
        StudentInfo other = (StudentInfo) object;
        if ((this.studentDbid == null && other.studentDbid != null) || (this.studentDbid != null && !this.studentDbid.equals(other.studentDbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "students.StudentInfo[ studentDbid=" + studentDbid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
