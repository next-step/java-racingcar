package calculator;

import java.util.Objects;

public class Num {
    private final int number;

    public Num(String number) {
        this(Integer.parseInt(number));
    }

    public Num(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Num plus(Num other) {
        return new Num(this.number + other.number);
    }

    public Num minus(Num other) {
        return new Num(this.number - other.number);
    }

    public Num times(Num other) {
        return new Num(this.number * other.number);
    }

    public Num divideBy(Num other) {
        if (other.number == 0) {
            throw new IllegalArgumentException("Dividend cannot be zero.");
        }

        return new Num(this.number / other.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Num Num = (Num) o;
        return number == Num.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
