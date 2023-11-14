package study.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String COMMA_COLON_DELIMITER = ",|:";

    private static final Pattern CUSTOM_DELIMITER_MATCHER = Pattern.compile("//(.)\\n(.*)");

    public static int cal(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return sum(splitWithDelimiter(text));
    }

    private static String[] splitWithDelimiter(String text) {
        Matcher matcher = CUSTOM_DELIMITER_MATCHER.matcher(text);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return text.split(COMMA_COLON_DELIMITER);
    }

    private static Integer sum(String[] stringArr) {
        int sum = 0;
        for (String str : stringArr) {
            sum += getNumber(str);
        }
        return sum;
    }

    private static int convertNumber(String numberStr) {
        try {
            return Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 format이 아닙니다.");
        }
    }

    private static int getNumber(String numberStr) {
        int convertedNumber = convertNumber(numberStr);
        if (convertedNumber < 0) {
            throw new RuntimeException("음수는 들어갈 수 없습니다.");
        }
        return convertedNumber;
    }
}
