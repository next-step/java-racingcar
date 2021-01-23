package calculator;

import java.util.*;

public class Calculator {
    String[] inputs;

    public double add(double a, double b) {
        return a + b;
    }

    public double substract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        return a / b;
    }

    public void getUserInput() {
        System.out.println("계산식을 입력해주세요.");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        inputs = input.split(" ");
    }

    public void start() {
        try {
            getUserInput();
            checkInputs();
            calculateResult();
        } catch (IllegalArgumentException e) {
            System.out.println("올바른 계산식을 입력해주세요.");
        }
    }

    private void calculateResult() {
        double result = Double.parseDouble(inputs[0]);

        for (int i = 1; i < inputs.length; i += 2) {
            String operator = inputs[i];
            String operand = inputs[i + 1];

            result = calculate(result, operator, Double.parseDouble(operand));
        }
        System.out.print(result);
    }

    private double calculate(double arg1, String op, double arg2) {
        if (op.equals("+")) {
            return add(arg1, arg2);
        } else if (op.equals("-")) {
            return substract(arg1, arg2);
        } else if (op.equals("*")) {
            return multiply(arg1, arg2);
        } else if (op.equals("/")) {
            return divide(arg1, arg2);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void checkInputs() {
        for (String input : inputs) {
            if (!isNumeric(input) && !isOp(input)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private boolean isOp(String op) {
        String OPERATORS = "+-*/";
        if (op.length() != 1) {
            return false;
        } else if (OPERATORS.contains(op)) {
            return true;
        } else {
            return false;
        }
    }
}
