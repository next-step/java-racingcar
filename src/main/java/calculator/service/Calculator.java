package calculator.service;

public class Calculator {

    private Calculator() {
    }

    public static int add(int prev, int next) {
        return prev + next;
    }

    public static int sub(int prev, int next) {
        return prev - next;
    }

    public static int multiply(int prev, int next) {
        return prev * next;
    }

    // TODO: 실수형 고려
    public static int divide(int prev, int next) {
        return prev / next;
    }
}
