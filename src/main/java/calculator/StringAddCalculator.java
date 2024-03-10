package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringAddCalculator {

    private static final int ZERO = 0;
    private static final int CUSTOM_SEPARATOR = 1;
    private static final int INPUT_STRING = 2;
    private static final String ONE_NUMBER_REGEX = "\\d+";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int calculate(String text) {
        if (text == null || text.isBlank()) {
            return ZERO;
        }

        if (hasContainNegativeNumber(text)) {
            throw new IllegalArgumentException(String
                    .format("text(%s)엔 음수가 포함되어 있습니다. 음수는 허용되지 않습니다.", text));
        }
        return sum(parse(text));
    }

    private static boolean hasContainNegativeNumber(String text) {
        return hasContainNegativeCharacter(parse(text));
    }

    private static boolean hasContainNegativeCharacter(String[] texts) {
        for (String stringNumber : texts) {
            return isNegative(stringNumber);
        }
        return false;
    }

    private static boolean isNegative(String stringNumber) {
        return Integer.parseInt(stringNumber) < 0;
    }

    private static int sum(String[] numbers) {
        int number = 0;
        for (String s : numbers) {
            number += Integer.parseInt(s);
        }
        return number;
    }

    private static String[] parse(String text) {
        if (!(text.contains(",") || text.contains(":") || text.matches(ONE_NUMBER_REGEX))) {
            return customParse(match(text));
        }
        return text.split(",|:");
    }

    private static String[] customParse(Matcher matcher) {
        if (!matcher.find()) {
            throw new IllegalArgumentException("주어진 문자열은 CUSTOM_PATTERN의 형태와 일치하지 않습니다.");
        }

        return matcher.group(INPUT_STRING).split(matcher.group(CUSTOM_SEPARATOR));
    }

    private static Matcher match(String text) {
        return CUSTOM_PATTERN.matcher(text);
    }

}
