package calculator;

import java.util.Objects;

public class PositiveInteger {

    private final int number;

    public PositiveInteger(int number) {
        if( number < 0 ) {
            throw new IllegalArgumentException();
        }

        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public PositiveInteger add(int number ) {
        return new PositiveInteger(this.number + number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveInteger that = (PositiveInteger) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}