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
}
