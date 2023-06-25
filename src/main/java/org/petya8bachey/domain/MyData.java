package org.petya8bachey.domain;

import jakarta.persistence.*;

@Entity @Table
public class MyData {
    @Id @GeneratedValue
    public Integer ID;
    public String data;
}