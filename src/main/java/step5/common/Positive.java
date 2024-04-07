package step5.common;

import static step5.common.Constant.NATURAL_FIRST;
import static step5.common.Constant.ZERO;

public class Positive {

    private int positive;

    public Positive() {
        this(NATURAL_FIRST);
    }

    public Positive(int positive) {
        isValid(positive);
        this.positive = positive;
    }

    public int positive() {
        return this.positive;
    }

    public Positive plusOne() {
        return new Positive(++positive);
    }

    private void isValid(int positive) {
        if (positive <= ZERO) throw new IllegalArgumentException("양수만 입력 가능합니다.");
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Positive && this.positive() == ((Positive) o).positive();
    }

    @Override
    public int hashCode() {
        return positive() * 13;
    }

}
