package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public int calculate(String input) {
        if (input == null || input.isEmpty())
            return 0;

        String splitterPattern = ",:";

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            splitterPattern += matcher.group(1);
            input = matcher.group(2);
        }

        return Arrays.stream(input.split("[" + splitterPattern + "]")).mapToInt(Integer::parseInt).sum();
    }
}
