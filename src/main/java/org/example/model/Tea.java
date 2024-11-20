package org.example.model;

import org.example.Format;
import org.example.Serialized;

@Serialized(format = Format.XML)
public class Tea {
    private String size;
    private String type;
    private double price;

    public Tea(String type, double price, String size) {
        this.type = type;
        this.price = price;
        this.size = size;
    }
}
