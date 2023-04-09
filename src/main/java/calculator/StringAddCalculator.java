package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {
    public static final int ZERO = 0;
    public static final String DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return ZERO;
        }

        return sum(toInts(split(text)));
    }

    private static List<String> split(String text) {
        if (hasCustomDelimiter(text)) {
            String customDelimiter = makeCustomDelimiter(text);
            return List.of(text.replace("//" + customDelimiter + "\n", "").split(customDelimiter));
        }
        return List.of(text.split(DELIMITER));
    }

    private static boolean hasCustomDelimiter(String text) {
        return text.startsWith("//") && text.contains("\n");
    }

    private static String makeCustomDelimiter(String text) {
        return text.substring(2, text.indexOf("\n"));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(List<Integer> numbers) {
        int num = ZERO;
        for (int number : numbers) {
            num += number;
        }
        return num;
    }


    private static List<Integer> toInts(List<String> values) {
        List<Integer> numbers = new ArrayList<>();
        for (String value : values) {
            numbers.add(toPositive(value));
        }
        return numbers;
    }

    private static int toPositive(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("양수만 입력 가능합니다.");
        }
        return number;
    }
}
