package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final int ZERO = 0;
    public static final String DELIMEITER = ",|:";
    public static final String PATTERN = "(?<=\\/\\/)[^\\/]*(?=\\\\n)";

    public static final Pattern CUSTOM_DELIMEITER = Pattern.compile(PATTERN);
    public static final String LINE_BREAK = "\\n";

    public static int calculator(String text) {
        int sum = ZERO;
        if (text == null || text.isBlank()) {
            return sum;
        }

        return sum(toPositiveInts(split(text)));
    }

    private static int[] toPositiveInts(String[] values) {
        int[] result = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            int value = toPositiveInt(values[i]);
            result[i] = value;
        }
        return result;
    }

    private static int toPositiveInt(String values) {
        int value = Integer.parseInt(values);
        if (value < 0)
            throw new RuntimeException("음수는 입력이 불가합니다. 양수를 입력하세요.");
        return value;
    }

    private static int sum(int[] values) {
        int sum = ZERO;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    private static String[] split(String text) {
        String customDelimiter = extractDelimiter(text);
        if (customDelimiter.isBlank()) {
            return text.split(DELIMEITER);
        }
        return text.substring(text.indexOf(LINE_BREAK) + 2).split(customDelimiter);
    }

    private static String extractDelimiter(String text) {
        String value = "";
        Matcher matcher = CUSTOM_DELIMEITER.matcher(text);
        while (matcher.find()) {
            if (matcher.group(0) == null)
                break;
            value = matcher.group(0);
        }

        return value;
    }
}
