package org.example.model;

import org.example.Serialized;

@Serialized
public class Dog {
    private String name;
    private int age;
    private String color;
    private int weight;

    public Dog(int weight, String color, int age, String name) {
        this.weight = weight;
        this.color = color;
        this.age = age;
        this.name = name;
    }
}
