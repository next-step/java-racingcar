package calculator;

import calculator.utils.validator.Validator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMETER = ",|:";
    private static final String CUSTOM_DELIMETER = "//(.)\n(.*)";

    private static StringAddCalculator instance;

    private StringAddCalculator() {}

    public static StringAddCalculator getInstance() {
        if (instance == null) {
            return new StringAddCalculator();
        }
        return instance;
    }

    public int splitAndSum(String text) {
        if (!Validator.validateUserInput(text)) {
            return 0;
        }

        return sum(split(text));
    }

    private int sum(int[] numbers) {
        int ret = 0;
        for (int number : numbers) {
            ret += number;
        }
        return ret;
    }

    private int toInt(String num) {
        int ret = Integer.parseInt(num);
        if (ret < 0) {
            throw new IllegalArgumentException("양의 정수가 입력되어야 합니다!");
        }
        return ret;
    }

    private int[] toInts(String[] numbers) {
        int[] ret = new int[numbers.length];
        for (int i = 0 ; i < numbers.length ; i++) {
            ret[i] = toInt(numbers[i]);
        }
        return ret;
    }

    private int[] split(String text) {
        if (Validator.hasCustomDelimeter(text)) {
            return toInts(splitNumberByCustomDelimeter(text));
        }
        return toInts(splitNumberByDefaultDelimeter(text));
    }

    private String[] splitNumberByCustomDelimeter(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMETER).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return new String[0];
    }

    private String[] splitNumberByDefaultDelimeter(String text) {
        return text.split(DEFAULT_DELIMETER);
    }
}
