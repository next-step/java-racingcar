package com.racingcar.car;

public class NamedCar extends Car {
    private static final int NAME_MAX_LENGTH = 4;
    private String name;

    public NamedCar(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("name must under 4 characters, name : " + name);
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
