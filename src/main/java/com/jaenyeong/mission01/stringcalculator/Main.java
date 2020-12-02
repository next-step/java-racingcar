package com.jaenyeong.mission01.stringcalculator;

import java.util.List;
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

    private static int getCalculationResult(String inputExpression) {
        final StringParser parser = new StringParser(inputExpression);

        final List<String> operators = parser.getOperators();
        final List<Integer> operands = parser.getOperands();
        final StringCalculator calculator = new StringCalculator(operators, operands);

        return calculator.calculateExpression();
    }
}
