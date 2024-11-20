package org.example;

import org.example.model.Dog;
import org.example.model.Tea;
import org.example.model.User;

public class Demo {
    static final int TRIALS = 1000000;
    public static void main(String[] args) {
        Serializator serializator = new Serializator();
        User user = new User("Jack", 25, "Grey", 1);
        System.out.println(serializator.serialize(user));

        Tea tea = new Tea("green", 2.50, "small");
        System.out.println(serializator.serialize(tea));

        Dog dog = new Dog(15, "black", 6, "Arnold");
        System.out.println(serializator.serialize(dog));

        // checking time needed for serializing with and without reflection

        long start, timeElapsed;
        start = System.currentTimeMillis();
        for (int i = 0; i < TRIALS; i++) {
            serializator.serialize(user);
        }
        timeElapsed = System.currentTimeMillis() - start;
        System.out.println("Time for serialization with reflection: " + timeElapsed + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < TRIALS; i++) {
            simpleSerialize(user);
        }
        timeElapsed = System.currentTimeMillis() - start;
        System.out.println("Time for simple serialization: " + timeElapsed + "ms");
    }
    public static String simpleSerialize(User user){
        return "{\n\t\"firstName\":\"" + user.getFirstName()
                + "\",\n\t\"lastName\":\"" + user.getLastName()
                + "\",\n\t\"id\":\"" + user.getId()
                + "\",\n\t\"age\":\"" + user.getAge() + "\"\n}";

    }
}