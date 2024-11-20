package org.example;

import org.example.model.Dog;
import org.example.model.Tea;
import org.example.model.User;

public class Demo {
    public static void main(String[] args) {
        Serializator serializator = new Serializator();
        User user = new User("Jack", 25, "Grey", 1);
        System.out.println(serializator.serialize(user));

        Tea tea = new Tea("green", 2.50, "small");
        System.out.println(serializator.serialize(tea));

        Dog dog = new Dog(15, "black", 6, "Arnold");
        System.out.println(serializator.serialize(dog));
    }
}