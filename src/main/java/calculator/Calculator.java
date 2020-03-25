package calculator;

public class Calculator {

    public static int plus(int left, int right) {
        return left + right;
    }

    public static int minus(int left, int right) {
        return left - right;
    }

    public static int multiply(int left, int right) {
        return left * right;
    }

    public static int division(int left, int right) {
        if (right == 0) {
            throw new IllegalArgumentException("Can't divide by 0");
        }
        return left / right;
    }
}
