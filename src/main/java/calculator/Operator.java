package calculator;

public class Operator {

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
