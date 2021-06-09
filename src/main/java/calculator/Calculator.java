package calculator;

public class Calculator {
    public int add(int a, int b) {

        return a + b;
    }

    public int subtract(int a, int b) {

        return a - b;
    }

    public int multiply(int a, int b) {

        return a * b;
    }

    public int division(int a, int b) {

        return a / b;
    }

    public void nullCheck(String input) {
        if (input == null || input.trim().equals(" ")) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }

    }

    public void operationCheck(String input) {
        if (!input.contains("+") || !input.contains("-") || !input.contains("*") || !input.contains("/")) {
            throw new IllegalArgumentException("입력값에 사칙연산이 없습니다.");
        }
    }
}
