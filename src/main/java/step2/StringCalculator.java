package step2;

import java.util.Arrays;
import java.util.List;

/**
 * 문자열 사칙 연산 계산기
 */
public class StringCalculator {

    private static final String NUMBERS_REGEXP = "[0-9]";
    private static final String EMPTY_SPACE = "";

    List<String> operations = Arrays.asList("+", "-", "*", "/");

    public int apply(String input) {
        // 입력시 유효성 검사 체크
        if (isBlank(input) || !isValidSymbol(input)) {
            throw new IllegalArgumentException();
        }

        // 데이터 가공을 할건데
        String[] split = input.split("");
        for( String item : split) {
            System.out.println(item);
        }

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
    public boolean isValidSymbol(String input) {
        String s = input.replaceAll(NUMBERS_REGEXP, EMPTY_SPACE);
        return operations.contains(s.trim());
    }

    public boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}
