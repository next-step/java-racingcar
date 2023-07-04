package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public int calculate(String input) {
        if (input == null || input.isEmpty())
            return 0;

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            String customSplitter = matcher.group(1);
            return Arrays.stream(matcher.group(2).split(customSplitter)).mapToInt(Integer::parseInt).sum();
        }

        return Arrays.stream(input.split("[,:]")).mapToInt(Integer::parseInt).sum();
    }
}
