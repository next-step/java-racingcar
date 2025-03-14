import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] tokens = splitText(text);
        int[] numbers = convertStringToIntList(tokens);
        return sumNumbers(numbers);
    }

    private static String[] splitText(String text) {
        Matcher m = pattern.matcher(text);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }
        return text.split("[,:]");
    }

    private static int[] convertStringToIntList(String[] numbers) {
        int[] converted = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            converted[i] = Integer.parseInt(numbers[i]);
        }
        return converted;
    }

    private static int sumNumbers(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number < 0)
                throw new RuntimeException();
            sum += number;
        }
        return sum;
    }
}
