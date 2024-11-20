package org.example;

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
}
