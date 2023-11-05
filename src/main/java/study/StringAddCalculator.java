package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int DEFAULT_SUM_VALUE = 0;
    private static StringConvertToInt stringConvertToInt;

    public StringAddCalculator(StringConvertToInt stringConvertToInt) {
        this.stringConvertToInt = stringConvertToInt;
    }

    public static int splitAndSum(String input) {
        if (!isNullOrEmpty(input)) {
            return sumElement(stringConvertToInt.stringConvertToInt(input));
        }
        return DEFAULT_SUM_VALUE;
    }

    private static int sumElement(int[] elements) {
        int result = 0;
        for (int element : elements) {
            result += element;
        }
        return result;
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}