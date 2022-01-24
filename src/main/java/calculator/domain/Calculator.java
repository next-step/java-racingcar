package calculator.domain;

import java.util.Scanner;

public class Calculator {

    private final Scanner scanner = new Scanner(System.in);

    public Calculator() {
    }

    public void startCalculate() {
        Expression expression;
        String input = getUserInput();

        try {
            expression = new Expression(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            startCalculate();
        }
    }

    private boolean checkDivideZero(Expression expression) {
        try {
            expression.calculate();
            expression.printResult();
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
            return true;
        }
        return false;
    }

    private String getUserInput() {
        System.out.println("식을 입력하세요");
        String str = scanner.nextLine();
        return str;
    }
}
