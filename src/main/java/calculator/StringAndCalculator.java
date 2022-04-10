package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAndCalculator {
    private final static String ABNORMAL_MATCH_PATTERN = "//(.)\n(.*)";
    private final static String NORMAL_MATCH_PATTERN = "[,:]";

    public static int splitAndSum(String text) {
        if (Objects.isNull(text) || text.equals("")) {
            return 0;
        }

        return sumIntegers(stringsToIntegers(textToStrings(text)));
    }

    private static String[] textToStrings(String text) {
        Matcher m = Pattern.compile(ABNORMAL_MATCH_PATTERN).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        } else {
            return text.split(NORMAL_MATCH_PATTERN);
        }
    }

    private static List<Integer> stringsToIntegers(String[] values) {
        return Arrays.stream(values).map(StringAndCalculator::stringToInt).collect(Collectors.toList());
    }

    private static int stringToInt(String value) {
        int intValue = Integer.parseInt(value);
        if (intValue < 0) {
            throw new RuntimeException();
        }
        return intValue;
    }

    private static int sumIntegers(List<Integer> values) {
        return values.stream().reduce(0, Integer::sum);
    }
}
