package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public int sum(String input) {
        if (isEmpty(input)) {
            return 0;
        }
        String[] split = split(input);
        return sum(toPositives(split));
    }

    private boolean isEmpty(String input) {
        return input == null || input.isEmpty() || input.isBlank();
    }

    private int sum(Positives positives) {
        return positives.sum();
    }

    private Positives toPositives(String[] input) {
        return new Positives(input);
    }


    private String[] split(String input) {
        Matcher matcher = Pattern.compile("//(.+)\n(.*)").matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String group = matcher.group(2);
            return group.split(delimiter);
        }
        return input.split("[:,]");
    }
}
