package com.seok.racing.domain;

import java.util.Objects;

public class Winner {
    private Racer racer;

    protected Winner(Racer racer) {
        this.racer = racer;
    }

    @Override
    public String toString() {
        return racer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winner winner = (Winner) o;
        return Objects.equals(racer, winner.racer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racer);
    }
}
