package step2.model;

import java.util.Objects;

public class MyNumber {
    private final int number;

    public MyNumber(int number) {
        this.number = number;
    }

    public MyNumber(String s) {
        this(Integer.parseInt(s));
    }

    public Integer getNumber() {
        return number;
    }

    public MyNumber add(MyNumber myNumber2) {
        return new MyNumber(this.number + myNumber2.number);
    }
    public MyNumber minus(MyNumber myNumber2) {
        return new MyNumber(this.number - myNumber2.number);
    }
    public MyNumber divide(MyNumber myNumber2) {
        valid(myNumber2);
        return new MyNumber(this.number / myNumber2.number);
    }
    public MyNumber multiply(MyNumber myNumber2) {
        return new MyNumber(this.number * myNumber2.number);
    }
    public static void valid(MyNumber num2) {
        if (num2.equals(new MyNumber(0))) {
            throw new IllegalArgumentException("나눗셈에서 분모는 0이 될 수 없습니다");
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyNumber myNumber = (MyNumber) obj;
        return this.number == myNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

