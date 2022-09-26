package step2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    private static final int ZERO = 0;
    private static final String SEPARATOR = "[,:]";
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    private StringAddCalculator() {
    }

    public static Positive splitAndSum(String text) {
        if (isBlank(text)) {
            return Positive.ZERO;
        }
        return sum(toPositives(split(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text) {
        Matcher matcher = PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split(SEPARATOR);
    }

    private static List<Positive> toPositives(String[] values) {
        return Arrays.stream(values).map(Positive::new).collect(Collectors.toList());
    }

    private static Positive sum(List<Positive> positives) {
        Positive sum = new Positive(ZERO);
        for (Positive positive : positives) {
            sum = sum.plus(positive);
        }
        return sum;
    }
}
