package calculator;

public class Calculator {

    public double adddition(double a, double b) {
        return a + b;
    }

    public double subtraction(double a, double b) {
        return a - b;
    }

    public double multiplication(double a, double b) {
        return a * b;
    }

    public double division(double a, double b) {
        if(b == 0) {
            throw new ArithmeticException("0으로 나눌수 없습니다.");
        }
        return a / b;
    }
}
