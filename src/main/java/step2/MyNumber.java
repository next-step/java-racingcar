package step2;

import java.util.Objects;

public class MyNumber {

    private int number;

    public MyNumber(String text) {
        Validation.validNullAndEmpty(text);
        this.number = Integer.parseInt(text);
    }

    public MyNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public MyNumber plus(MyNumber second) {
        return new MyNumber(this.number + second.number);
    }

    public MyNumber minus(MyNumber second) {
        return new MyNumber(this.number - second.number);
    }

    public MyNumber multiple(MyNumber second) {
        return new MyNumber(this.number * second.number);
    }

    public MyNumber divide(MyNumber second) {
        return new MyNumber(this.number / second.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyNumber)) return false;
        MyNumber myNumber = (MyNumber) o;
        return number == myNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
