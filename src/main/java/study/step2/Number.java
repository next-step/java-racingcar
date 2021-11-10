package study.step2;

import java.util.Objects;

public class Number {
    private final int number;

    public Number(String s) {
        this(Integer.parseInt(s));
    }

    public Number(int number) {
        this.number = number;
    }

    public Number plus(Number other) {
        return new Number(this.number + other.number);
    }

    public Number minus(Number other) {
        return new Number(this.number - other.number);
    }

    public Number times(Number other) {
        return new Number(this.number * other.number);
    }

    public Number dividedBy(Number other) {
        if(other.number == 0) {
            throw new IllegalArgumentException("분모가 0일 될 수 없습니다.");
        }
        return new Number(this.number / other.number);
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return this.number == number.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
