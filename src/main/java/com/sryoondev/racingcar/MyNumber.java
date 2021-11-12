package com.sryoondev.racingcar;

import java.util.Objects;

public class MyNumber {
    private int number;

    public MyNumber(int number) {
        this.number = number;
    }

    public MyNumber(String text) {
        this(Integer.parseInt(text));
    }

    public MyNumber plus(MyNumber second) {
        return new MyNumber(this.number + second.number);
    }

    public MyNumber minus(MyNumber second) {
        return new MyNumber(this.number - second.number);
    }

    public MyNumber multiply(MyNumber second) {
        return new MyNumber(this.number * second.number);
    }

    public MyNumber divide(MyNumber second) {
        return new MyNumber(this.number / second.number);
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
