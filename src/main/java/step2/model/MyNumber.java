package step2.model;

import java.util.Objects;

public class MyNumber {
    private final int number;

    public Integer getNumber() {
        return number;
    }
    public MyNumber(int number) {
        this.number = number;
    }

    public MyNumber(String s) {
        this(Integer.parseInt(s));
    }

    public MyNumber add(MyNumber myNumber2) {
        return new MyNumber(this.number + myNumber2.number);
    }
    public MyNumber minus(MyNumber myNumber2) {
        return new MyNumber(this.number - myNumber2.number);
    }
    public MyNumber divide(MyNumber myNumber2) {
        return new MyNumber(this.number / myNumber2.number);
    }
    public MyNumber multiply(MyNumber myNumber2) {
        return new MyNumber(this.number * myNumber2.number);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyNumber myNumber = (MyNumber) obj;
        return this.number == myNumber.number;
    }

}

