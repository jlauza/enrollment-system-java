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
@Table(name = "rooms", catalog = "test", schema = "")
@NamedQueries({
    @NamedQuery(name = "Rooms_1.findAll", query = "SELECT r FROM Rooms_1 r")
    , @NamedQuery(name = "Rooms_1.findByRoomdbid", query = "SELECT r FROM Rooms_1 r WHERE r.roomdbid = :roomdbid")
    , @NamedQuery(name = "Rooms_1.findByRoomName", query = "SELECT r FROM Rooms_1 r WHERE r.roomName = :roomName")})
public class Rooms_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Room_dbid")
    private Integer roomdbid;
    @Basic(optional = false)
    @Column(name = "RoomName")
    private String roomName;

    public Rooms_1() {
    }

    public Rooms_1(Integer roomdbid) {
        this.roomdbid = roomdbid;
    }

    public Rooms_1(Integer roomdbid, String roomName) {
        this.roomdbid = roomdbid;
        this.roomName = roomName;
    }

    public Integer getRoomdbid() {
        return roomdbid;
    }

    public void setRoomdbid(Integer roomdbid) {
        Integer oldRoomdbid = this.roomdbid;
        this.roomdbid = roomdbid;
        changeSupport.firePropertyChange("roomdbid", oldRoomdbid, roomdbid);
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        String oldRoomName = this.roomName;
        this.roomName = roomName;
        changeSupport.firePropertyChange("roomName", oldRoomName, roomName);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomdbid != null ? roomdbid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rooms_1)) {
            return false;
        }
        Rooms_1 other = (Rooms_1) object;
        if ((this.roomdbid == null && other.roomdbid != null) || (this.roomdbid != null && !this.roomdbid.equals(other.roomdbid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "students.Rooms_1[ roomdbid=" + roomdbid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
