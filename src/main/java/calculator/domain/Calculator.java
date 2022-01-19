package calculator.domain;

public class Calculator {

    private Calculator() {}

    public static long add(long num1, long num2) {
        return num1 + num2;
    }

    public static long sub(long num1, long num2) {
        return num1 - num2;
    }

    public static long mul(long num1, long num2) {
        return num1 * num2;
    }

    public static long div(long num1, long num2) {
        return num1 / num2;
    }
}
