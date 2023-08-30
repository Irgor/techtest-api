package com.example.techtestapi.user;

import com.example.techtestapi.phone.Phone;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String type;
    private String document;
    private String registry;
    private LocalDate birthday;
    private String phone;
    private Boolean active;

    public User() {
    }

    public User(int id,
                String name,
                String type,
                String document,
                String registry,
                LocalDate birthday,
                String phone,
                Boolean active) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.document = document;
        this.registry = registry;
        this.birthday = birthday;
        this.phone = phone;
        this.active = active;
    }

    public User(String name,
                String type,
                String document,
                String registry,
                LocalDate birthday,
                String phone,
                Boolean active) {
        this.name = name;
        this.type = type;
        this.document = document;
        this.registry = registry;
        this.birthday = birthday;
        this.phone = phone;
        this.active = active;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", document='" + document + '\'' +
                ", registry='" + registry + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", active=" + active +
                '}';
    }
}
