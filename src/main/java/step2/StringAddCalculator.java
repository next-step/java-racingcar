package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");


    public StringAddCalculator() {

    }

    public int calculate(String input) {
        if (isBlank(input)) {
            return PositiveInteger.ZERO.getIntValue();
        }
        return splitAndSum(input).getIntValue();
    }

    private boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private PositiveInteger splitAndSum(String input) {
        return splitWithDelimiter(input).stream()
                .map(Integer::parseInt)
                .map(PositiveInteger::new)
                .reduce(PositiveInteger::sum).orElseThrow();
    }

    private List<String> splitWithDelimiter(String input) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return Arrays.asList(m.group(2).split(customDelimiter));
        }

        return Arrays.asList(input.split(DELIMITER));
    }
}
