package step4.common;

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
        return o instanceof Positive && this.positive() == ((Positive) o).positive();
    }

    @Override
    public int hashCode() {
        return positive() * 13;
    }

}
