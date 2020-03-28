package calculator;

import java.util.Arrays;
import java.util.List;

public class NumberParser {
    private static final String DELIMITER = " ";
    private static List<String> operators = Arrays.asList("+", "-", "*", "/");

    static void checkTextNullOrEmpty(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    static void checkMathOperator(String text) {
        if (!operators.contains(text)) {
            throw new IllegalArgumentException("연산자가 아닙니다.");
        }
    }

    static long parseText(String textNumber) {
        try {
            return (Long.parseLong(textNumber));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    static String[] toSplitText(String text) {
        return text.split(DELIMITER);
    }

}
