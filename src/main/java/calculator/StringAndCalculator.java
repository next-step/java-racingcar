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

        return sumIntegers(stringsToIntegers(textToStrings(text)));
    }

    private static String[] textToStrings(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        } else {
            return text.split("[,:]");
        }
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

    private static int sumIntegers(List<Integer> values) {
        int result = 0;
        for (Integer value : values) {
            result += value;
        }
        return result;
    }
}
