package study.racing.step2;

import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern INTEGER_PATTERN = Pattern.compile("^0|[-]?[0-9]*$");
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n");

    public static int calculate(String text) {
        if (StringUtils.isBlank(text)) return 0;
        if (isOnlyNumber(text)) Integer.parseInt(text);

        String delimiter = extractDelimiter(text);

        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()) text = m.replaceAll("");

        return calculate(text, delimiter);
    }


    private static int calculate(String text, String delimiter) {
        return Arrays.stream(text.split(delimiter))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static String extractDelimiter(String text) {
        String delimiter;
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);

        if (m.find()) {
            delimiter = m.group(1);
        } else if (isSeparateNumbers(text, ",|:")) {
            delimiter = ",|:";
        } else {
            delimiter = "";
        }

        return delimiter;
    }

    private static boolean isSeparateNumbers(String text, String delimiter) {
        return Arrays.stream(text.split(delimiter))
                .allMatch(c -> {
                    if (c.contains("-")) throw new RuntimeException("음의 정수가 포함되어 있습니다.");
                    Matcher m = INTEGER_PATTERN.matcher(c);
                    if (m.matches()) {
                        return true;
                    } else {
                        throw new RuntimeException("숫자 이외의 값이 포함되어 있습니다.");
                    }
                });
    }

    private static boolean isOnlyNumber(String text) {
        try {
            return Integer.valueOf(text) instanceof Integer;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
