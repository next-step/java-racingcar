import java.util.Arrays;

public class Calculator {

    static int calculate(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        if (!text.startsWith("//")) {
            return getSumWhenSeparatedByColonOrComma(text);
        }

        return getSumWhenSeparatorIsGiven(text);
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static int getSumWhenSeparatedByColonOrComma(String text) {
        return Arrays.stream(
                        text.split("[,:]"))
                .mapToInt(Integer::parseInt)
                .map(Calculator::throwIfNegativeNumberOrPass)
                .sum();
    }

    private static int getSumWhenSeparatorIsGiven(String text) {
        int endIndexOfSeparator = text.indexOf("\n");
        String separator = getSeparator(text.substring(0, endIndexOfSeparator + 1));
        String numbersForm = text.substring(endIndexOfSeparator + 1);

        return Arrays.stream(
                        Arrays.stream(numbersForm.split(separator))
                                .mapToInt(Integer::parseInt)
                                .map(Calculator::throwIfNegativeNumberOrPass)
                                .toArray())
                .sum();
    }


    private static int throwIfNegativeNumberOrPass(int num) {
        if (num < 0) {
            throw new RuntimeException("Negative Numbers Input");
        }
        return num;
    }

    private static String getSeparator(String text) {
        String separator = text.replaceAll("//|\n", "").replace("", "|");
        return separator.substring(1, separator.length()-1);
    }
}
