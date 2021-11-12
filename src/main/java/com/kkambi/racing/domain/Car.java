package com.kkambi.racing.domain;

public class Car {

    private static final String LOCATION_UNIT = "-";

    private final StringBuilder location = new StringBuilder();

    public void move() {
        location.append(LOCATION_UNIT);
    }

    public String getLocation() {
        return location.toString();
    }
}
