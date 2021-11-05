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
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Num Num = (Num) object;
        return number == Num.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
