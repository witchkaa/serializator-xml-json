package org.example;

@Serialized(format = Format.JSON)
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
