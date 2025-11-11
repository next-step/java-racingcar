import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return sum(toInteger(m.group(2).split(customDelimiter)));
        }
        return sum(toInteger(input.split(",|:")));
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static int[] toInteger(String[] inputs) {
        int[] numbers = new int[inputs.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }
        return numbers;
    }

    private static int sum(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
