package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    static final String DEFAULT_DELIMITER_REGEX = ",|:";
    static final String CUSTOM_DELIMITER_REGEX = "(\\/\\/)(.*)(\\n)(.*)";
    static final int CUSTOM_DELIMITER_GROUP_NUMBER = 2;
    static final int BODY_GROUP_NUMBER = 4;

    public static int add(String s) {
        if(isBlank(s)) return 0;

        int[] intArray = IntArrayFromStrNumbersArray(getStrNumbers(s));

        throwExceptionIfMinusValueIncluded(intArray);

        return sum(intArray);
    }

    private static String[] getStrNumbers(String s) {
        Matcher customDelimiterRegexMatcher = customDelimiterRegexMatcher(s);
        if(isCustomDelimiterInput(customDelimiterRegexMatcher)) {
            String customDelimiter = getCustomDelimiter(customDelimiterRegexMatcher);
            return strNumbersSplitedByCustomDelimiter(customDelimiterRegexMatcher, customDelimiter);
        }else{
            return strNumbersOfDefaultDelimiter(s);
        }
    }

    private static String[] strNumbersOfDefaultDelimiter(String s) {
        return s.split(DEFAULT_DELIMITER_REGEX);
    }

    private static String[] strNumbersSplitedByCustomDelimiter(Matcher customDelimiterRegexMatcher, String customDelimiter) {
        return customDelimiterRegexMatcher.group(BODY_GROUP_NUMBER).split(customDelimiter);
    }

    private static String getCustomDelimiter(Matcher customDelimiterRegexMatcher) {
        return customDelimiterRegexMatcher.group(CUSTOM_DELIMITER_GROUP_NUMBER);
    }

    private static boolean isCustomDelimiterInput(Matcher customDelimiterRegexMatcher) {
        return customDelimiterRegexMatcher.find();
    }

    private static Matcher customDelimiterRegexMatcher(String s) {
        return Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(s);
    }

    private static int[] IntArrayFromStrNumbersArray(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
    }

    private static void throwExceptionIfMinusValueIncluded(int[] numbers) {
        Arrays.stream(numbers).forEach(StringAddCalculator::throwExceptionIfMinusValue);
    }

    private static void throwExceptionIfMinusValue(int value) {
        if(value < 0) throwRuntimeException("Minus Value Error!");
    }

    private static void throwRuntimeException(String message) {
        throw new RuntimeException(message);
    }

    private static boolean isBlank(String s) {
        return s == null || s.equals("");
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
