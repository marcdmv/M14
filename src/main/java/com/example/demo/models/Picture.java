package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name="pictures")
public class Picture {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name="name", nullable=false, length=100)
    private String name;

    @Column(name="author", nullable = false, length=100)
    private String author;

    @Column(name="shop_id", nullable = false, length=11)
    private long shopId;

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
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public long getShopId() {
        return shopId;
    }
    public void setShopId(long shopId) {
        this.shopId = shopId;
    }
}