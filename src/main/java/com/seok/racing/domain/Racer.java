package com.seok.racing.domain;

import java.util.Objects;

public class Racer {

    private String name;

    public Racer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Racer racer = (Racer) o;
        return Objects.equals(name, racer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
