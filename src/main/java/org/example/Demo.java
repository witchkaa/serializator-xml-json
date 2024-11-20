package org.example;

public class Demo {
    public static void main(String[] args) {
        Serializator serializator = new Serializator();
        User user = new User("Jack", 25, "Grey", 1);
        String res = serializator.serialize(user);
        System.out.println(res);
    }
}