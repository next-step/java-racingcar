package study;

public class Calculator {
    int num = 0;
    String[] input;

    public Calculator(String input) {
        this.input = input.split(" ");
    }

    public int calculation() {
        num = Integer.parseInt(input[0]);
        for (int i = 1; i < input.length; i += 2) {
            int operatorNum = Integer.parseInt(input[i + 1]);
            num = operator(operatorNum, input[i]);
        }
        return num;
    }

    private int operator(int operatorNum, String operator) {
        switch (operator) {
            case "+":
                return plus(num, operatorNum);
            case "-":
                return minus(num, operatorNum);
            case "*":
                return multiplied(num, operatorNum);
            case "/":
                return divide(num, operatorNum);
            default:
                throw new IllegalArgumentException();
        }
    }

    public int plus(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int multiplied(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }
}
