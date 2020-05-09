package calculator;

@FunctionalInterface
public interface Calculator {

    double calculate(String input);

    default double plus(double a, double b) {
        return a + b;
    }

    default double minus(double a, double b) {
        return a - b;
    }

    default double multiply(double a, double b) {
        return a * b;
    }

    default double divide(double a, double b) {
        if(b == 0) {
            throw new ArithmeticException("division with zero is not allowed.");
        }
        return a / b;
    }
}
