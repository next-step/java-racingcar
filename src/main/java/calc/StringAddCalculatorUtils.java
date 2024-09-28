package calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculatorUtils {
    private static final Pattern  CUSTOM_DELIMITER_PATTERN = Pattern.compile(StringAddCalculatorCharacter.PATTERN.getText());

    public static int split(String text) {
        String[] tokens = text.split(StringAddCalculatorCharacter.REGEX.getText());
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            tokens = matcher.group(2).split(customDelimiter);
        }
        return sum(tokens);
    }

    public static int sum(String[] tokens) {
        int result = 0;
        for (String token : tokens) {
            isNegative(token);
            result += Integer.parseInt(token);
        }
        return result;
    }

    public static void isNegative(String s) {
        if(Integer.parseInt(s) < 0 || !Character.isDigit(s.charAt(0))) {
            throw new RuntimeException("올바른 형식이 아닙니다.");
        }
    }
}
