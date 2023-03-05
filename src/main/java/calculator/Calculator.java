package calculator;

import java.math.BigInteger;

public class Calculator {

    private Calculator() {
    }

    static BigInteger add(BigInteger number1, BigInteger number2) {
        return number1.add(number2);
    }

    static BigInteger subtract(BigInteger number1, BigInteger number2) {
        return number1.subtract(number2);
    }

    static BigInteger multiply(BigInteger number1, BigInteger number2) {
        return number1.multiply(number2);
    }

    static BigInteger divide(BigInteger number1, BigInteger number2) {
        return number1.divide(number2);
    }
}
