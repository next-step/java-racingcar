package calculator;

import java.util.Objects;

public class MyNumber {
    private final int number;

    public MyNumber(String text) {
        this(Integer.parseInt(text));
    }

    public MyNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public MyNumber plus(MyNumber other) {
        return new MyNumber(this.number + other.number);
    }

    public MyNumber minus(MyNumber other) {
        return new MyNumber(this.number - other.number);
    }

    public MyNumber multiple(MyNumber other) {
        return new MyNumber(this.number * other.number);
    }

    public MyNumber divideBy(MyNumber other) {
        checkDenominator(other.number);
        return new MyNumber(this.number / other.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyNumber myNumber = (MyNumber) o;
        return number == myNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    private void checkDenominator(int denominator) {
        if(denominator == 0) {
            throw new IllegalArgumentException("분모는 0이 될 수 없습니다.");
        }
    }
}
