package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_SEPARATOR = Pattern.compile("//(.)\\n(.*)");
    private static final String COMMA_OR_COLON = ",|:";

    public static int calculate(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(split(text));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text) {
        Matcher matcher = CUSTOM_SEPARATOR.matcher(text);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return text.split(COMMA_OR_COLON);
    }

    private static int sum(String[] values) {
        int result = 0;
        for (String value : values) {
            int number = isPositive(getNumber(value));
            result += number;
        }
        return result;
    }

    private static int getNumber(String text) {
        int number = 0;
        try {
            number = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("전달 값의 숫자 이외의 값이 포함되어 있습니다.");
        }
        return number;
    }

    private static int isPositive(int number) {
        if (number < 0) {
            throw new RuntimeException("전달 값의 음수가 포함되어 있습니다.");
        }
        return number;
    }
}