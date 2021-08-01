package com.racingcar.car;

public class NamedCar extends Car {
    private static final String EMPTY = "";
    private static final int NAME_MAX_LENGTH = 4;
    private String name;

    public NamedCar(int id, String name) {
        if (name.length() > NAME_MAX_LENGTH || EMPTY.equals(name.trim())) {
            throw new IllegalArgumentException("name must 1-4 characters, name : " + name);
        }

        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
