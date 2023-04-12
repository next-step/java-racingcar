package com.next.step.step3.domain.vo;

import java.util.Objects;

public class CarName {

    private final String name;

    public CarName(String name) {
        this.name = name;
    }

    public String carName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
