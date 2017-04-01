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
@Table(name = "section", catalog = "test", schema = "")
@NamedQueries({
    @NamedQuery(name = "Section_1.findAll", query = "SELECT s FROM Section_1 s")
    , @NamedQuery(name = "Section_1.findBySectionId", query = "SELECT s FROM Section_1 s WHERE s.sectionId = :sectionId")
    , @NamedQuery(name = "Section_1.findBySectionName", query = "SELECT s FROM Section_1 s WHERE s.sectionName = :sectionName")})
public class Section_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "section_id")
    private Integer sectionId;
    @Column(name = "SectionName")
    private String sectionName;

    public Section_1() {
    }

    public Section_1(Integer sectionId) {
        this.sectionId = sectionId;
    }
    
    Section_1(int aInt, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /*
    Section_1(int aInt, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        Integer oldSectionId = this.sectionId;
        this.sectionId = sectionId;
        changeSupport.firePropertyChange("sectionId", oldSectionId, sectionId);
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        String oldSectionName = this.sectionName;
        this.sectionName = sectionName;
        changeSupport.firePropertyChange("sectionName", oldSectionName, sectionName);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sectionId != null ? sectionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Section_1)) {
            return false;
        }
        Section_1 other = (Section_1) object;
        if ((this.sectionId == null && other.sectionId != null) || (this.sectionId != null && !this.sectionId.equals(other.sectionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "students.Section_1[ sectionId=" + sectionId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
