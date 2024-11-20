package org.example;

import java.lang.reflect.Field;

/**
 * A class for serializing Java objects into JSON or XML format using custom annotations and reflection.
 */
public class Serializator {

    /**
     * Serializes the given object into the format specified by the @Serialized annotation.
     *
     * @param obj the object to serialize
     * @return a string representing the serialized object in JSON or XML format,
     *         or {@code null} if the class is not annotated with @Serialized
     */
    public String serialize(Object obj) {
        Class<?> cls = obj.getClass();
        Serialized annotation = cls.getAnnotation(Serialized.class);
        if (annotation == null) {
            System.err.println("Cannot serialize " + cls.getName() + " because it has no Serialized");
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            Format format = annotation.format();
            Field[] fields = cls.getDeclaredFields();

            switch (format) {
                case JSON:
                    sb.append("{\n\t");
                    for (int i = 0; i < fields.length; i++) {
                        Field field = fields[i];
                        field.setAccessible(true);
                        JsonField jsonField = field.getAnnotation(JsonField.class);
                        if (jsonField == null) {
                            continue;
                        }
                        String key = (!jsonField.name().isEmpty())
                                ? jsonField.name()
                                : field.getName();
                        try {
                            sb.append("\"").append(key).append("\":");
                            Object value = field.get(obj);
                            if (value instanceof String) {
                                sb.append("\"").append(value).append("\"");
                            } else {
                                sb.append(value);
                            }
                            if (i < fields.length - 1) {
                                sb.append(",\n\t");
                            }
                        } catch (IllegalAccessException e) {
                            System.err.println("Cannot access field: " + field.getName());
                        }
                    }
                    sb.append("\n}");
                    return sb.toString();

                case XML:
                    sb.append("<").append(cls.getSimpleName().toLowerCase()).append(">\n");
                    for (Field field : fields) {
                        field.setAccessible(true);
                        XmlField xmlField = field.getAnnotation(XmlField.class);
                        if (xmlField == null) {
                            continue;
                        }
                        String key = (!xmlField.name().isEmpty())
                                ? xmlField.name()
                                : field.getName();
                        try {
                            sb.append("\t<").append(key).append(">");
                            sb.append(field.get(obj));
                            sb.append("</").append(key).append(">\n");
                        } catch (IllegalAccessException e) {
                            System.err.println("Cannot access field: " + field.getName());
                        }
                    }
                    sb.append("</").append(cls.getSimpleName().toLowerCase()).append(">");
                    return sb.toString();

                default:
                    return null;
            }
        }
    }
}
