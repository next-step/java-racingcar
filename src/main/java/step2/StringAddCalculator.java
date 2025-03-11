package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        String[] numbers = m.find()
                ? m.group(2).split(Pattern.quote(m.group(1))) :
                input.split(",|:");

        String negative = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .filter(n -> n < 0)
                .mapToObj(String::valueOf)
                .reduce((a, b) -> a + b)
                .orElse("");

        if (!negative.isEmpty()) throw new RuntimeException();

        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }
}
