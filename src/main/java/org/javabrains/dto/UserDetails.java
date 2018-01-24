package org.javabrains.dto;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * Created by Karen on 09-Jul-17.
 */

@Entity
@NamedQuery(name = "UserDetails.byId", query = "from UserDetails where id=?")
@NamedNativeQuery(name = "UserDetails.byName",
        query = "select * from UserDetails where username = ?",
        resultClass = UserDetails.class)
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
