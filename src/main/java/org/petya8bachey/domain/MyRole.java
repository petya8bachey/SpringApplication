package org.petya8bachey.domain;

import javax.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;
@Entity @Table
public class MyRole implements GrantedAuthority {
    @Id @GeneratedValue
    public Integer ID;
    public String name;

    public MyRole(String name) {
        this.name = name;
    }
    public MyRole() {
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
