package calculator;

import java.util.Objects;

public class MyNumber {
    private int number;

    public MyNumber(int number) {
        this.number = number;
    }

    public MyNumber plus(MyNumber that) {
        return new MyNumber(this.number + that.number);
    }

    public MyNumber minus(MyNumber that) {
        return new MyNumber(this.number - that.number);
    }

    public MyNumber times(MyNumber that) {
        return new MyNumber(this.number * that.number);
    }

    public MyNumber divideBy(MyNumber that) {
        return new MyNumber(this.number / that.number);
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
