package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class StringUtil {

    private static final String BASIC_REGEX = ",|:";

    public static List<Integer> convertTextToIntegers(String text) {
        return Arrays.stream(split(text))
            .map(StringUtil::toInteger)
            .collect(Collectors.toList());
    }

    private static String[] split(String text) {
        if (text.isBlank()) {
            return new String[]{"0"};
        }

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            return matcher.group(2).split(customSeparator);
        }
        return text.split(BASIC_REGEX);
    }

    private static int toInteger(String value) {
        int parsedValue;
        try {
            parsedValue = Integer.parseInt(value);
        } catch (NumberFormatException ignore) {
            throw new NumberFormatException("잘못된 숫자 형식입니다");
        }
        return parsedValue;
    }
}
