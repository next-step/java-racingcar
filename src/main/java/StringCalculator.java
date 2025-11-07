import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static List<String> delimeter = new ArrayList<>(List.of(":", ","));

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int[] numbers = parseInput(input);

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

        int[] numbers = new int[strNumbers.length];
        for (int i = 0; i < strNumbers.length; i++) {
            numbers[i] = Integer.parseInt(strNumbers[i]);

            if (numbers[i] < 0) {
                throw new RuntimeException("음수 값이 전달되었습니다.");
            }
        }

        return numbers;
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
