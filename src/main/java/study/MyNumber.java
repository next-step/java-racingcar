package study;

import java.util.Objects;

public class MyNumber {
    private final int number;

    public MyNumber(String s) {
        this(Integer.parseInt(s));
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
        if(other.number == 0) {
            throw new IllegalArgumentException("분모가 0일 될 수 없습니다.");
        }
        return new MyNumber(this.number / other.number);
    }

    public int getNumber() {
        return this.number;
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

}
