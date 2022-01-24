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
            expression.calculate();
            expression.printResult();
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println(e.getMessage());
            startCalculate();
        }
    }

    private String getUserInput() {
        System.out.println("식을 입력하세요");
        String str = scanner.nextLine();
        return str;
    }
}
