import java.util.Arrays;
import java.util.stream.Stream;

public class Calculator {

    static int calculate(String text) {
        if (text == null) {
            return 0;
        }

        if (text.isEmpty()) {
            return 0;
        }

        if (!text.startsWith("//")) {
            return Arrays.stream(
                    text.split(",|:"))
                    .mapToInt(Integer::parseInt)
                    .map(num -> throwIfNegativeNumberOrPass(num))
                    .sum();
        }

        int endIndexOfSeparator = text.indexOf("\n");
        String separator = getSeparator(text.substring(0, endIndexOfSeparator + 1));
        String numbersForm = text.substring(endIndexOfSeparator + 1);

        int[] numbers = Arrays.stream(
                 numbersForm
                .split(separator))
                .mapToInt(Integer::parseInt)
                .map(num -> throwIfNegativeNumberOrPass(num))
                .toArray();

        return Arrays.stream(numbers).sum();
    }

    private static int throwIfNegativeNumberOrPass(int num) {
        if (num < 0) {
            throw new RuntimeException();
        }
        return num;
    }

    private static String getSeparator(String text) {
        String separator = text.replaceAll("//|\n", "").replace("", "|");
        return separator.substring(1, separator.length()-1);
    }
}
