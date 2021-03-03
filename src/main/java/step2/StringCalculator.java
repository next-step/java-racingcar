package step2;

import java.util.Arrays;
import java.util.List;

/**
 * 문자열 사칙 연산 계산기
 */
public class StringCalculator {

    private static final String EXCEPT_NUMBERS = "[^\\d]";
    List<String> operations = Arrays.asList("+", "-", "*", "/");

    // default method
    public int apply(String input) {
        if (isBlank(input) || isValidSymbol(input))
            throw new IllegalArgumentException();

        return 0;
    }

    // operation
    public int plus(int a, int b) {
        return a + b;
    }

    public int subtract(int minuend, int subtrahend) {
        return minuend - subtrahend;
    }

    public int multiply(Integer multiplicand, Integer multiplier) {
        return multiplicand * multiplier;
    }

    public int divide(Integer dividend, Integer divisor) {
        return dividend / divisor;
    }

    // validation
    private boolean isValidSymbol(String input) {
        return input.matches(EXCEPT_NUMBERS);
    }

    private boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}
