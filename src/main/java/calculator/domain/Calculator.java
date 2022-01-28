package calculator.domain;

import java.util.Scanner;

public class Calculator {

    private final Scanner scanner = new Scanner(System.in);

    public Calculator() {
    }

    public void startCalculate() {
        try {
            Expression expression = new Expression(getUserInput());
            expression.calculate();
            expression.printResult();
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println(e.getMessage());
            startCalculate();
        }
    }

    private String getUserInput() {
        System.out.println("식을 입력하세요");
        return scanner.nextLine();
    }
}
