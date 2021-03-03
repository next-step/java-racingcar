package step2;

import java.awt.datatransfer.StringSelection;
import java.util.stream.Stream;

/**
 * 문자열 사칙 연산 계산기
 *
 */
public class StringCalculator {

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

    public int apply(String input) {
        if(isBlank(input)) throw new IllegalArgumentException();
        return 0;
    }

    private boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}
