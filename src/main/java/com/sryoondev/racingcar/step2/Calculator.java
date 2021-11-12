package com.sryoondev.racingcar.step2;

public class Calculator {
    public static MyNumber calculate(String text) {
        validate(text);

        String[] split = text.split(" ");
        MyNumber first = new MyNumber(split[0]);

        for (int i = 1; i < split.length; i += 2) {
            MyOperator operator = new MyOperator(split[i]);
            MyNumber second = new MyNumber(split[i + 1]);
            first = operator.operate(first, second);
        }
        return first;
    }

    public static void validate(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("문자열이 비었습니다.");
        }

    }
}
