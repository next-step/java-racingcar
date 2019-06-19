package com.mommoo.step2;

public class Car {
    private final String NAME;
    private final int POSITION;

    public Car(String name, int position) {
        this.NAME = name;
        this.POSITION = position;
    }

    public String getName() {
        return NAME;
    }

    public int getPosition() {
        return POSITION;
    }
}
