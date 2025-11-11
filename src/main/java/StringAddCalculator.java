import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }
        return sum(toInts(split(input)));
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(String input) {
        String defaultDelimiter = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(defaultDelimiter + "|" + Pattern.quote(customDelimiter));
        }
        return input.split(defaultDelimiter);
    }

    private static int[] toInts(String[] inputs) {
        int[] numbers = new int[inputs.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = toInt(inputs[i]);
        }
        return numbers;
    }

    private static int toInt(String input) {
        int number = Integer.parseInt(input);

        if (number < 0) {
            throw new RuntimeException("음수가 포함되었습니다.");
        }
        return number;
    }

    private static int sum(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
