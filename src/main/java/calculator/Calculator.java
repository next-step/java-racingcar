package calculator;

public class Calculator {

    public static int calculate(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return plus(num1, num2);
            case "-":
                return minus(num1, num2);
            case "*":
                return times(num1, num2);
            case "/":
                return divide(num1, num2);
            default:
                throw new IllegalArgumentException("사칙연산자가 아닙니다.");
        }
    }

    private static int plus(int num1, int num2) {
        return num1 + num2;
    }

    private static int minus(int num1, int num2) {
        return num1 - num2;
    }

    private static int times(int num1, int num2) {
        return num1 * num2;
    }

    private static int divide(int num1, int num2) {
        if (num1 < num2) {
            throw new IllegalArgumentException("나눗셈 결과값은 정수만 허용합니다.");
        }
        return num1 / num2;
    }
}
