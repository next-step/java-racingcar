package edu.nextstep.camp.model.car;

public class Name {
    public static final int NAME_LIMIT = 5;

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name of(String name) {
        if (name == null || name.isEmpty() || name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException("invalid name: " + name);
        }

        return new Name(name);
    }

    public String toString() {
        return name;
    }
}
