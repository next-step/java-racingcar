package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private StringAddCalculator() {}

    public static int splitAndSum(String text) {
        if (StringUtils.isEmpty(text)) {
            return 0;
        }

        return sum(toPositiveNumbers(split(text)));
    }

    private static int[] toPositiveNumbers(String[] textTokens) {
        return Arrays.stream(textTokens)
                .mapToInt(textToken -> {
                    int number = Integer.parseInt(textToken);
                    if (number < 0) {
                        throw new RuntimeException();
                    }
                    return number;
                })
                .toArray();
    }

    private static String[] split(String str) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        if (m.find()) {
            String delimiter = m.group(1);
            return m.group(2).split(delimiter);
        }

        return str.split("[,:]");
    }

    public static int sum(int[] positiveNumbers) {
        return Arrays.stream(positiveNumbers)
                .sum();
    }
}
