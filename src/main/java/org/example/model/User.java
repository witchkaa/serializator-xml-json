package org.example.model;

import org.example.Format;
import org.example.Serialized;

@Serialized(format = Format.JSON)
public class User {
    private String firstName;
    private String lastName;
    private int id;
    private int age;

    public User(String lastName, int age, String firstName, int id) {
        this.lastName = lastName;
        this.age = age;
        this.firstName = firstName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }
}
