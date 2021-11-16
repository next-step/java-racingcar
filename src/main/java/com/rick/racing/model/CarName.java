package com.rick.racing.model;

import java.util.Objects;

public class CarName {

    private final String value;

    private CarName(String name) {
        this.value = name;
    }

    public static CarName create(String name) {
        return new CarName(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName = (CarName) o;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
