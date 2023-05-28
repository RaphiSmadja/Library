package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "ID", nullable = false)
    private CustomerEntity customerEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public CustomerEntity getUserEntity() {
        return customerEntity;
    }

    public void setUserEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }
}
