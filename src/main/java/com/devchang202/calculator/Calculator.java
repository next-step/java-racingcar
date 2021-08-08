package com.devchang202.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int divide(int a, int b) {
        return a / b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    String[] parseEquation(String userInput) {
        String[] equation = userInput.trim().split(" ");

        for (int i = 0; i < equation.length - 1; i = i + 2) {
            checkNumber(equation[i]);
            checkOperator(equation[i + 1]);
        }
        checkNumber(equation[equation.length - 1]);

        return equation;
    }

    int getResultOfCalculator(String[] parsedEquation) {
        int result = Integer.parseInt(parsedEquation[0]);
        for (int i = 1; i < parsedEquation.length; i = i + 2) {
            result = calculate(parsedEquation[i], result, Integer.parseInt(parsedEquation[i + 1]));
        }

        return result;
    }

    int calculate(String op, int a, int b) throws IllegalArgumentException {
        switch (op) {
            case "+":
                return add(a, b);
            case "-":
                return subtract(a, b);
            case "*":
                return multiply(a, b);
            case "/":
                return divide(a, b);
            default:
                throw new IllegalArgumentException("invalid operator");
        }
    }

    void checkOperator(String op) throws  IllegalArgumentException {
        if (isBlank(op) || !isOperator(op)) {
            throw new IllegalArgumentException();
        }
    }

    void checkNumber(String num) throws IllegalArgumentException {
        if (!isNumebr(num)) {
            throw new IllegalArgumentException();
        }
    }

    boolean isBlank(String input) {
        return (input.equals("") || input.equals(" "));
    }

    boolean isOperator(String input) {
        return (input.equals("+") || input.equals("*") || input.equals("/") || input.equals("-"));
    }

    boolean isNumebr(String input) {
        if (isBlank(input) || isOperator(input)) {
            return false;
        }

        try {
            int num = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    String inputEquation() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        while (true) {
            try {
                System.out.println("input equation : ");
                System.out.println("Result : " + calculator.getResultOfCalculator(calculator.parseEquation(calculator.inputEquation())));
            } catch (IOException e) {
                System.out.println("try again. : " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("invalid equation, try again. : " + e.getMessage());
            }
        }
    }
}
