package com.jaenyeong.mission01.stringcalculator;

public class Main {

    public static void main(String[] args) {
        System.out.println("사칙 연산을 수행할 문자열을 입력해주세요");
        Input input = new Input();
        final String expression = input.inputString();

        final StringCalculator calculator = new StringCalculator();

        System.out.println(calculator.calculate(expression));
    }
}
