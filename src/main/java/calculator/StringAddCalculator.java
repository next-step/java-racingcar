package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAddCalculator {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if(isNullOrEmpty(text)) return 0;
        String[] strings = splitString(text);
        int[] ints = convertArrayStringToInteger(strings);
        return sum(ints);
    }

    private static boolean isNullOrEmpty(String text) {
        if(text == null) return true;
        return text.isEmpty();
    }

    private static String[] splitString(String text) {
        String[] strings = {text};
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
        if(m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        } else if(text.contains(",") || text.contains(":")) {
            return text.split(",|:");
        }
        return strings;
    }

    private static int[] convertArrayStringToInteger(String[] strings) {
        return Stream.of(strings).mapToInt(StringAddCalculator::parseInt).toArray();
    }

    private static int parseInt(String string) {
        int intNum = Integer.parseInt(string);
        if(intNum < 0) throw new RuntimeException("음수입니다.");
        return intNum;
    }

    private static int sum(int[] ints) {
        return Arrays.stream(ints).sum();
    }
}
