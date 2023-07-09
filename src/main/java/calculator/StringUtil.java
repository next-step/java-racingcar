package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtil {

    private static final String BASIC_REGEX = ",|:";

    public static String[] split(String text) {
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

    public static int toInt(String value) {
        int parsedValue;
        try {
            parsedValue = Integer.parseInt(value);
        } catch (NumberFormatException ignore) {
            throw new NumberFormatException("잘못된 숫자 형식입니다");
        }
        return parsedValue;
    }
}
