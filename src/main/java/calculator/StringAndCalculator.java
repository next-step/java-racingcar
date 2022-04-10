package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAndCalculator {
    public static int splitAndSum(String text) {
        if (Objects.isNull(text) || text.equals("")) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            List<Integer> integers = stringsToIntegers(tokens);
            return sumValues(integers);
        } else {
            String[] tokens = text.split("[,:]");
            List<Integer> integers = stringsToIntegers(tokens);
            return sumValues(integers);
        }
    }

    private static int sumValues(List<Integer> values) {
        int result = 0;
        for (Integer value : values) {
            result += value;
        }
        return result;
    }

    private static List<Integer> stringsToIntegers(String[] values) {
        List<Integer> integers = new ArrayList<>();
        for (String value : values) {
            integers.add(stringToInt(value));
        }
        return integers;
    }

    private static int stringToInt(String value) {
        int intValue = Integer.parseInt(value);
        if (intValue < 0) {
            throw new RuntimeException();
        }
        return intValue;
    }
}
