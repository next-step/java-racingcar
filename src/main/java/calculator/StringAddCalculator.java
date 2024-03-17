package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int ZERO = 0;
    private static final int CUSTOM_SEPARATOR = 1;
    private static final int INPUT_STRING = 2;
    private static final String ONE_NUMBER_REGEX = "\\d+";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public int calculate(String text) {
        if (isBlank(text)) {
            return ZERO;
        }
        return sum(toPositiveInts(parse(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private int[] toPositiveInts(String[] texts) {
        int[] numbers = new int[texts.length];
        for (int i = 0; i < texts.length; i++) {
            isNegative(texts[i]);
            numbers[i] = Integer.parseInt(texts[i]);
        }
        return numbers;
    }

    private void isNegative(String text) {
        if (Integer.parseInt(text) < 0) {
            throw new IllegalArgumentException(String
                    .format("text(%s)는 음수입니다.", text));
        }
    }

    private int sum(int[] numbers) {
        int number = 0;
        for (int n : numbers) {
            number += n;
        }
        return number;
    }

    private String[] parse(String text) {
        if (!(text.contains(",") || text.contains(":") || text.matches(ONE_NUMBER_REGEX))) {
            return customParse(match(text));
        }
        return text.split(",|:");
    }

    private String[] customParse(Matcher matcher) {
        if (!matcher.find()) {
            throw new IllegalArgumentException("주어진 문자열은 CUSTOM_PATTERN의 형태와 일치하지 않습니다.");
        }

        return matcher.group(INPUT_STRING).split(matcher.group(CUSTOM_SEPARATOR));
    }

    private Matcher match(String text) {
        return CUSTOM_PATTERN.matcher(text);
    }

}
