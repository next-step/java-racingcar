package stringcalculator;

import java.util.Objects;

public class Number {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number1 = (Number) o;
        return getNumber() == number1.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
