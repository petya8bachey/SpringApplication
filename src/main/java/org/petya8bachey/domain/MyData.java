package org.petya8bachey.domain;

import javax.persistence.*;

@Entity @Table
public class MyData {
    @Id @GeneratedValue
    public Integer ID;
    public String data;

    public MyData(String data) {
        this.data = data;
    }
}