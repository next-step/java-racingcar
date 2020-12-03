package com.jaenyeong.mission01.stringcalculator;

import java.util.Scanner;

public class Main {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("사칙 연산을 수행할 문자열을 입력해주세요");
        final String inputExpression = inputExpression();
        final int result = getCalculationResult(inputExpression);

        System.out.println(result);
    }

    private static String inputExpression() {
        final String inputExpression = SC.nextLine();
        SC.close();

        return inputExpression;
    }

    private static int getCalculationResult(String expression) {
        final StringCalculator calculator = new StringCalculator();

        return calculator.calculate(expression);
    }
}
