import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int splitAndSum(String input) {
        int sum = 0;
        if (input == null || input.isBlank()) {
            return sum;
        }

        String[] numbers;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            numbers = m.group(2).split(customDelimiter);

            for (String number : numbers) {
                sum += Integer.parseInt(number);
            }
        } else {
            numbers = input.split(",|:");
            for (String number : numbers) {
                sum += Integer.parseInt(number);
            }
        }

        return sum;
    }
}
