package org.example.model;

import org.example.Format;
import org.example.JsonField;
import org.example.Serialized;

@Serialized(format = Format.JSON)
public class User {
    @JsonField(name = "firstName")
    private String firstName;
    @JsonField(name = "lastName")
    private String lastName;
    @JsonField(name="id")
    private int id;
    @JsonField(name="age")
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
