package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int ZERO = 0;
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DELIMITER_PATTERN_NUMBER = 1;
    private static final int INPUT_PATTERN_NUMBER = 2;

    public int splitAndSum(String inputText) {

        if (checkEmpty(inputText)) {
            return ZERO;
        }

        return sumNumbers(splitText(inputText));
    }

    private boolean checkEmpty(String text) {

        //  나중에는 StringUtils.hasText() 사용하면 될 것 같다고 생각이 든다.
        return text == null || text.isEmpty();
    }

    private String[] splitText(String text) {
        if (isMatchCustomPattern(text)) {
            return splitUsingCustomPattern(text);
        }

        return text.split("[,|:]");
    }

    private boolean isMatchCustomPattern(String text) {
        return CUSTOM_PATTERN.matcher(text).find();
    }

    private String[] splitUsingCustomPattern(String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);

        if (matcher.find()) {
            return matcher.group(INPUT_PATTERN_NUMBER).split(matcher.group(DELIMITER_PATTERN_NUMBER));
        }

        return new String[0];
    }

    private int sumNumbers(String[] numbers) {

        if(isNegativeNumber(numbers)) {
            return Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .sum();
        }

        throw new RuntimeException();
    }

    private boolean isNegativeNumber(String[] numbers) {

        return (Arrays.stream(numbers)
                .allMatch(number -> Integer.parseInt(number) > 0));
    }
}
