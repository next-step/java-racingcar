package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern ONLY_NUMBER = Pattern.compile("^[0-9]*$");
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public int splitAndSum(String inputText) {

        if (checkEmpty(inputText)) {
            return 0;
        }

        if (inputText.length() == 1) {
            return parseFormat(inputText);
        }

        return sumNumbers(splitText(inputText));
    }

    private boolean checkEmpty(String text) {

        //  나중에는 StringUtils.hasText() 사용하면 될 것 같다고 생각이 든다.
        return text == null || text.isEmpty();
    }

    private int parseFormat(String text) {

        if (!ONLY_NUMBER.matcher(text).find()) {
            throw new NumberFormatException();
        }

        return Integer.parseInt(text);
    }

    private String[] splitText(String text) {
        if (isMatchCustomPattern(text)) {
            return splitCustomPattern(text);
        }

        return text.split(",|:");
    }

    private boolean isMatchCustomPattern(String text) {
        return CUSTOM_PATTERN.matcher(text).find();
    }

    private String[] splitCustomPattern(String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);

        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }

        //  matcher 에 안 걸리는 경우는...?
        return null;
    }

    private int sumNumbers(String[] numbers) {

        if(checkNegativeNumber(numbers)) {
            return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
        }

        throw new RuntimeException();
    }

    private boolean checkNegativeNumber(String[] numbers) {

        if(Arrays.stream(numbers).allMatch(number -> Integer.parseInt(number) > 0)) {
            return true;
        }

        return false;
    }
}
