package org.example.model;

import org.example.Format;
import org.example.Serialized;
import org.example.XmlField;

/**
 * A model class representing a Tea. It is annotated with the @Serialized annotation to specify
 * that it should be serialized into XML format.
 */
@Serialized(format = Format.XML)
public class Tea {
    @XmlField(name = "cup_size")
    private String cupSize;
    @XmlField(name = "type")
    private String type;
    @XmlField(name = "price")
    private double price;

    public Tea(String type, double price, String cupSize) {
        this.type = type;
        this.price = price;
        this.cupSize = cupSize;
    }
}
