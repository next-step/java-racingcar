package calculator;

import java.util.*;

public class Calculator {
    String[] inputs;
    private final String OPERATORS = "+-*/";

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {

        if(Double.isInfinite(a/b) || Double.isNaN(a/b) ) {
            System.out.println(a/b);
            throw new IllegalArgumentException();
        }
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
            takeArguments();
        } catch (IllegalArgumentException e) {
            System.out.println("올바른 계산식을 입력해주세요.");
        }
    }


    private void takeArguments() {
        double result = Double.parseDouble(inputs[0]);

        for (int i = 1; i < inputs.length; i += 2) {
            String operator = inputs[i];
            String operand = inputs[i + 1];

            result = calculate(result, operator, Double.parseDouble(operand));
        }
        System.out.print(result);
    }

    public double calculate(double arg1, String op, double arg2) {
        if (op.equals("+")) {
            return add(arg1, arg2);
        }
        if (op.equals("-")) {
            return subtract(arg1, arg2);
        }
        if (op.equals("*")) {
            return multiply(arg1, arg2);
        }
        if (op.equals("/")) {
            return divide(arg1, arg2);
        }
        throw new IllegalArgumentException();
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

        if (op.length() != 1) {
            return false;
        } else return OPERATORS.contains(op);
    }
}
