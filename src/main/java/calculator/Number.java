package calculator;

import java.util.Objects;

public class Number {

    private int number;

    public Number(int number) {
        this.number = number;
    }

    Number(String number) {
        this.number = Integer.parseInt(number);
    }

    Number add(Number operand) {
        return new Number(this.number + operand.number);
    }

    Number subtract(Number operand) {
        return new Number(this.number - operand.number);
    }

    Number multiply(Number operand) {
        return new Number(this.number * operand.number);
    }

    Number dividedBy(Number operand) {
        if (operand.number == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return new Number(this.number / operand.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
