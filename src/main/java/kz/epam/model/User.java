package kz.epam.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Khamid_Sarmanov on 1/8/2016.
 */
@Entity
@Table(name = "APP_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "SSO_ID", unique = true, nullable = false)
    private String ssoId;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "STATE", nullable = false)
    private String state = State.ACTIVE.getState();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "APP_USER_USER_PROFILE",
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "USER_PROFILE_ID")}
    )
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSsoID() {
        return ssoId;
    }

    public void setSsoID(String ssoId) {
        this.ssoId = ssoId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((ssoId == null) ? 0 : ssoId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (id != other.id)
            return false;
        if (ssoId == null) {
            if (other.ssoId != null)
                return false;
        } else if (!ssoId.equals(other.ssoId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", ssoId=" + ssoId + ", password=" + password + ", state=" + state + ", userProfiles=" + userProfiles + "]";
    }
}
