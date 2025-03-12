import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] numbers = m.group(2).split(customDelimiter);
            return sumNumbers(numbers);
        } else {
            try {
                int number = Integer.parseInt(text);
                if (number < 0)
                    throw new RuntimeException();
            } catch (NumberFormatException ignored) {}

            String[] numbers = text.split("[,:]");
            return sumNumbers(numbers);
        }
    }

    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        try {
            for (String number : numbers) {
                int parsed = Integer.parseInt(number);
                if (parsed < 0)
                    throw new RuntimeException();
                sum += Integer.parseInt(number);
            }
        } catch (NumberFormatException ignored) {}
        return sum;
    }
}
