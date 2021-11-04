package study02;

import java.util.Objects;

/**
 * .
 */
public class CustomNumber {

    private final int number;

    public CustomNumber(String text) {
        this(Integer.parseInt(text));
    }

    public CustomNumber(int number) {
        this.number = number;
    }

    public CustomNumber plus(CustomNumber other) {
        return new CustomNumber(this.number + other.number);
    }

    public CustomNumber minus(CustomNumber other) {
        return new CustomNumber(this.number - other.number);
    }

    public CustomNumber times(CustomNumber other) {
        return new CustomNumber(this.number * other.number);
    }

    public CustomNumber dividedBy(CustomNumber other) {
        if (other.number == 0) {
            throw new IllegalArgumentException();
        }
        return new CustomNumber(this.number / other.number);
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomNumber number1 = (CustomNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
