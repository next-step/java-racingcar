import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static String[] split(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        String delimiterRegex = "[,:]";
        return input.split(delimiterRegex);
    }

    public static int sum(String input) {
        if (input == null) return 0;
        if (input.isEmpty()) return 0;

        String[] tokens = split(input);

        int[] numbers = Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean hasNegative = Arrays.stream(numbers).anyMatch(number -> number < 0);

        if (hasNegative) throw new RuntimeException("음수가 존재합니다.");

        return Arrays.stream(numbers).sum();
    }
}
