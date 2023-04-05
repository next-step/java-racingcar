import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String text) {
        if (text == null) {
            return 0;
        }
        if (text.isEmpty()) {
            return 0;
        }

        try {
            int number = Integer.parseInt(text);
            if (number < 0) {
                throw new RuntimeException();
            }
            return number;
        } catch (NumberFormatException ignored) {}

        String[] splitStrings = StringSplitPolicy.splitByPolicy(text);
        int[] ints = parseStringArrayToInts(splitStrings);
        return sumIntArray(ints);
    }

    private static int[] parseStringArrayToInts(String[] strings) {
        int[] parsedNumbers = new int[strings.length];
        try {
            for (int i = 0; i < strings.length; i++) {
                int parsedNumber = Integer.parseInt(strings[i]);
                if (parsedNumber < 0) {
                    throw new RuntimeException();
                }
                parsedNumbers[i] = parsedNumber;
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
        return parsedNumbers;
    }

    private static int sumIntArray(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
