package org.example.model;

import org.example.Serialized;
import org.example.XmlField;

/**
 * A model class representing a Dog. It is annotated with the @Serialized annotation to specify
 * that it should be serialized into XML format.
 */
@Serialized
public class Dog {
    @XmlField(name = "name")
    private String name;
    @XmlField(name = "age")
    private int age;
    @XmlField(name = "fur_color")
    private String furColor;
    @XmlField(name = "weight")
    private int weight;

    public Dog(int weight, String furColor, int age, String name) {
        this.weight = weight;
        this.furColor = furColor;
        this.age = age;
        this.name = name;
    }
}
