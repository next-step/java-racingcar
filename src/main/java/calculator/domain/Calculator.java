package calculator.domain;

import java.util.Scanner;

public class Calculator {

    public Calculator() {
    }

    public void startCalculate() {
        Expression expression;
        String input;
        do {
            input = getUserInput();
            expression = new Expression(input);
        } while (checkDivideZero(expression));
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
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        while (!Validator.checkValidate(str)) {
            System.out.println("유효한 식이 아닙니다. 다시 입력하세요.");
            str = scanner.nextLine();
        }

        return str;
    }
}
