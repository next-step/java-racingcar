import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static List<String> delimeter = new ArrayList<>(List.of(":", ","));

    public static int calculate(String input) {
        if (isBlank(input)) {
            return 0;
        }

        return sum(parseInput(input));
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    private static int[] parseInput(String input) {
        String expression = extractCustomDelimiter(input);
        String regex = String.join("|", delimeter);
        String[] strNumbers =  expression.split(regex);

        return convertToIntArray(strNumbers);
    }

    private static int[] convertToIntArray(String[] strNumbers) {
        int[] numbers = new int[strNumbers.length];
        for (int i = 0; i < strNumbers.length; i++) {
            numbers[i] = Integer.parseInt(strNumbers[i]);
            validateNumber(numbers[i]);
        }

        return numbers;
    }

    private static void validateNumber(int num) {
        if (num < 0) {
            throw new RuntimeException("음수 값이 전달되었습니다.");
        }
    }

    private static String extractCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (matcher.find()) {
            delimeter.add(matcher.group(1));
            return matcher.group(2);
        }

        return input;
    }
}
