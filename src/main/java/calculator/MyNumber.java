package calculator;

import java.util.Objects;

/**
 * Created by owen.ny on 2021/11/03.
 */
public class MyNumber {
    private final int number;

    public MyNumber(int number) {
        this.number = number;
    }

    public MyNumber(String number) {
        this.number = Integer.parseInt(number);
    }

    public MyNumber plus(MyNumber number) {
        return new MyNumber(this.number + number.number);
    }

    public MyNumber minus(MyNumber number) {
        return new MyNumber(this.number - number.number);
    }

    public MyNumber multiply(MyNumber number) {
        return new MyNumber(this.number * number.number);
    }

    public MyNumber division(MyNumber number) {
        if (number.number == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return new MyNumber(this.number / number.number);
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
