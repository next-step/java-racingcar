package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final int EMPTY_TEXT = 0;
    private static final String BASE_REGEX = ",|:";

    public int addOperation(String text) {
        if (text == null) {
            return EMPTY_TEXT;
        }
        String[] numbers = split(text);
        int result = add(numbers);
        return result;
    }

    private static String[] split(String text) {
        String regex = BASE_REGEX;
        Matcher m = Pattern.compile("//(.)\\n(.*)").matcher(text);
        if (m.find()) {
            String separator = m.group(1);
            regex = regex + "|" + separator;
            text = m.group(2);
        }
        return text.split(regex);
    }

    private int add(String[] textArray) {
        return Arrays.stream(textArray).mapToInt(i -> textCheck(i)).sum();
    }

    public int textCheck(String text) {
        if (text == null || text.isEmpty()) {
            return EMPTY_TEXT;
        }
        if (text.chars().allMatch(Character::isDigit)) {
            return Integer.parseInt(text);
        }
        throw new RuntimeException();
    }

}
