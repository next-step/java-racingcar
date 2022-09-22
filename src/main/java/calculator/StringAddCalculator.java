package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAddCalculator {
    private static final String COMMA_OR_COLON = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public static int splitAndSum(String text) {
        if(isNullOrEmpty(text)) return 0;
        return sum(toInt(splitString(text)));
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] splitString(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if(m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(COMMA_OR_COLON);
    }

    private static int[] toInt(String[] strings) {
        return Stream.of(strings).mapToInt(StringAddCalculator::parseInt).toArray();
    }

    private static int parseInt(String string) {
        return isPositive(string);
    }

    private static int isPositive(String string) {
        int intNum = Integer.parseInt(string);
        if(intNum < 0) throw new RuntimeException("음수입니다.");
        return intNum;
    }

    private static int sum(int[] ints) {
        return Arrays.stream(ints).sum();
    }
}
