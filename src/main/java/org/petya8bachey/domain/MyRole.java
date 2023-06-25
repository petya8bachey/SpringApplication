package org.petya8bachey.domain;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;
@Entity @Table
public class MyRole implements GrantedAuthority {
    @Id
    public Integer ID;
    public String name;
    @ManyToMany
    public Set<MyUser> myUsers;

    public MyRole(Integer id) {
        this.ID = id;
    }

    public MyRole(Integer id, String name) {
        this.ID = id;
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
