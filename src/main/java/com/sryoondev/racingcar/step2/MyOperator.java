package com.sryoondev.racingcar.step2;

public class MyOperator {
    String operator;

    public MyOperator(String text) {
        this.operator = text;
    }

    public MyNumber operate(MyNumber first, MyNumber second) {
        if ("+".equals(this.operator)) {
            return first.plus(second);
        }
        if ("-".equals(this.operator)) {
            return first.minus(second);
        }
        if ("*".equals(this.operator)) {
            return first.multiply(second);
        }
        if ("/".equals(this.operator)) {
            return first.divide(second);
        }
        throw new IllegalArgumentException("지원하지 않는 연산자 입니다.");
    }
}
