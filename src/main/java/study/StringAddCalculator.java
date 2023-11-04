package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

     final String DEFAULT_DELIMITER_REGEX = ",|:";
     final String CUSTOM_DELIMITER_REGEX = "\\/\\/(.*)\\n(.*)";
     final int CUSTOM_DELIMITER_GROUP_NUMBER = 1;
     final int BODY_GROUP_NUMBER = 2;

    public int add(String input) {
        if(isEmpty(input)){
            return 0;
        }

        int[] intArray = intArrayFromStrNumbersArray(getStrNumbers(input));

        throwExceptionIfMinusValueIncluded(intArray);

        return sum(intArray);
    }

    private String[] getStrNumbers(String s) {
        Matcher customDelimiterRegexMatcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(s);

        if(customDelimiterRegexMatcher.find()) {
            String customDelimiter = customDelimiterRegexMatcher.group(CUSTOM_DELIMITER_GROUP_NUMBER);
            return customDelimiterRegexMatcher.group(BODY_GROUP_NUMBER).split(customDelimiter);
        }

        return s.split(DEFAULT_DELIMITER_REGEX);
    }


    private  int[] intArrayFromStrNumbersArray(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
    }

    private  void throwExceptionIfMinusValueIncluded(int[] numbers) {
        Arrays.stream(numbers).forEach(StringAddCalculator::throwExceptionIfMinusValue);
    }

    private static void throwExceptionIfMinusValue(int value) {
        if(value < 0) {
            throw new RuntimeException("Minus Value Error !!!");
        }
    }

    private  boolean isEmpty(String s) {
        return s == null || s.equals("");
    }

    private  int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
