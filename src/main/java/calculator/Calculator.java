package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static void validate(String value) {
        int result;
        try {
            result = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닙니다.");
        }

        if (result < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    public static String[] parse(String text) {
        if (text.isEmpty()) {
            return new String[]{""};
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        String[] result = text.split(":|,");
        if (m.find()) {
            String customDelimiter = m.group(1);
            result = m.group(2).split(customDelimiter);
        }

        for (String value : result) {
            validate(value);
        }

        return result;
    }
}
