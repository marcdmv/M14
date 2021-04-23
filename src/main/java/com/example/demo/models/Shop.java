package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name="shops")
public class Shop {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name="name", nullable=false, length=100)
    private String name;

    @Column(name="capacity", nullable = false, length=11)
    private long capacity;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getCapacity() {
        return capacity;
    }
    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }
}
