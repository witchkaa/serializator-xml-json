package org.example;

public class Serializator {
    public String serialize(Object obj) {
        Class<?> cls = obj.getClass();
        Serialized annotation = cls.getAnnotation(Serialized.class);
        if (annotation == null) {
            System.err.println("Cannot serialize " + cls.getName() + " because it has no Serialized");
            return null;
        } else {
            Format format = annotation.format();
            return switch (format) {
                case JSON -> "{\"" + cls.getName() + " {}}\n";
                case XML -> "<" + cls.getName() + ">\n";
            };
        }
    }
}
