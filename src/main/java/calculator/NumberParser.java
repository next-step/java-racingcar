package calculator;

import java.util.Arrays;
import java.util.List;

public class NumberParser {

    private static List<String> operatorList = Arrays.asList("+", "-", "*", "/");

    static void checkTextNullOrEmpty(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    static void checkMathOperator(String text) {
        if (!operatorList.contains(text)) {
            throw new IllegalArgumentException("연산자가 아닙니다.");
        }
    }

    static long parseText(String textNumber) {
        try {
            return (Long.parseLong(textNumber));
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    static String[] toSplitStringList(String text) {
        return text.split(" ");
    }

}
