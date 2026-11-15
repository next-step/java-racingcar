package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.*?)\n(.*)", Pattern.DOTALL);
    private static final String DEFAULT_SEPARATOR = ",|:";

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        return sum(toNonNegativeNumbers(separate(input)));
    }

    private static List<String> separate(String input) {
        String target = input;

        String separator = DEFAULT_SEPARATOR;
        Matcher m = CUSTOM_SEPARATOR_PATTERN.matcher(target);
        if (m.matches()) {
            CustomSeparator customSeparator = new CustomSeparator(m.group(1));
            separator = separator + "|" + customSeparator.toRegex();
            target = m.group(2);
        }

        return List.of(target.split(separator));
    }

    private static List<NonNegativeNumber> toNonNegativeNumbers(List<String> tokens) {
        return tokens.stream().map(NonNegativeNumber::new).toList();
    }

    private static int sum(List<NonNegativeNumber> numbers) {
        return numbers.stream().mapToInt(NonNegativeNumber::getValue).sum();
    }
}
