package study02;

import java.util.Objects;

/**
 * .
 */
public class MyNumber {

    private final int number;

    public MyNumber(String text) {
        this(Integer.parseInt(text));
    }

    public MyNumber(int number) {
        this.number = number;
    }

    public MyNumber plus(MyNumber other) {
        return new MyNumber(this.number + other.number);
    }

    public MyNumber minus(MyNumber other) {
        return new MyNumber(this.number - other.number);
    }

    public MyNumber times(MyNumber other) {
        return new MyNumber(this.number * other.number);
    }

    public MyNumber dividedBy(MyNumber other) {
        if (other.number == 0) {
            throw new IllegalArgumentException();
        }
        return new MyNumber(this.number / other.number);
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
        MyNumber number1 = (MyNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
