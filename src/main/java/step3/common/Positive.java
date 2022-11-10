package step3.common;

import step3.domain.RacingCar;

public class Positive {

    private static final int ZERO = 0;

    private int positive;

    public Positive() {
        this(ZERO);
    }

    public Positive(int positive) {
        this.positive = positive;
    }

    public int positive() {
        return this.positive;
    }

    public Positive plusOne() {
        return new Positive(++positive);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Positive && this.positive() == ((Positive) o).positive()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return positive() * 13;
    }

}
