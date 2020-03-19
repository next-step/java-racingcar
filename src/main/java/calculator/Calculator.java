package calculator;

import jdk.internal.util.xml.impl.Input;

import javax.xml.validation.Validator;

public class Calculator {
    InputValidator validator;
    public int sum;

    public Calculator() {
        this.validator = new InputValidator();
        this.sum = 0;
    }

    public int calculate(String inputs) {
        validator.nullCheck(inputs);
        String[] inputArray = inputs.split(" ");
        int sum = parseInt(inputArray[0]);
        for (int i = 1; i < inputArray.length; i = i + 2) {
            sum = operate(sum, inputArray[i], inputArray[i + 1]);
        }
        return sum;
    }

    private int operate(int leftNumber, String operator, String rightNumber) {
        validator.operatorCheck(operator);
        return operation(leftNumber, parseInt(rightNumber), operator);
    }

    private int operation(int leftNumber, int rightNumber, String operator) {
        if ("+".equals(operator)) {
            return add(leftNumber, rightNumber);
        }
        if ("-".equals(operator)) {
            return substract(leftNumber, rightNumber);
        }
        if ("*".equals(operator)) {
            return multiple(leftNumber, rightNumber);
        }
        if ("/".equals(operator)) {
            return divide(leftNumber, rightNumber);
        }
        return 0;
    }

    private int parseInt(String input) {
        return Integer.parseInt(input);
    }

    public int add(int left, int right) {
        return left + right;
    }

    public int substract(int left, int right) {
        return left - right;
    }

    public int multiple(int left, int right) {
        return left * right;
    }

    public int divide(int left, int right) {
        return left / right;
    }

}
