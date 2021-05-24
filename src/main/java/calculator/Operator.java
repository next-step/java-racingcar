package calculator;

public class Operator {
    private final String symbol;

    public Operator(String symbol) {
        this.symbol = symbol;
    }

    public int operate(int number1, int number2) {
        if (symbol.equals("+")) {
            return plus(number1, number2);
        }
        if (symbol.equals("-")) {
            return minus(number1, number2);
        }
        if (symbol.equals("*")) {
            return multiply(number1, number2);
        }
        if (symbol.equals("/")) {
            return divide(number1, number2);
        }
        throw new IllegalStateException();
    }

    int plus(int number1, int number2) {
        return number1 + number2;
    }

    int minus(int number1, int number2) {
        return number1 - number2;
    }

    int multiply(int number1, int number2) {
        return number1 * number2;
    }

    int divide(int number1, int number2) {
        if (number2 == 0) {
            throw new IllegalArgumentException();
        }
        return number1 / number2;
    }
}
