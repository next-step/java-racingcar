package stringcalculator;

import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    public String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int calculate(String input) {
        if (isNullOrBlank(input)) {
            throw new IllegalArgumentException("입력 값이 공백 문자열이거나 null 입니다.");
        }
        String[] expressions = input.split(" ");

        int firstOperand = Integer.parseInt(expressions[0]);

        for (int i = 1; i < expressions.length; i = i + 2) {
            firstOperand = calculate(firstOperand, Integer.parseInt(expressions[i + 1]), expressions[i].toString());
        }

        return firstOperand;
    }

    private boolean isNullOrBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private int calculate(int firstOperand, int secondOperand, String operator) {
        if (operator.equals("+")) {
            return add(firstOperand, secondOperand);
        } else if (operator.equals("-")) {
            return subtract(firstOperand, secondOperand);
        } else if (operator.equals("*")) {
            return multiple(firstOperand, secondOperand);
        } else if (operator.equals("/")) {
            return divide(firstOperand, secondOperand);
        } else {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }

    }

    private int add(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }

    private int subtract(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }

    private int multiple(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }

    private int divide(int firstOperand, int secondOperand) {
        if (secondOperand == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return firstOperand / secondOperand;
    }

}