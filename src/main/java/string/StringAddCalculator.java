package string;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        int result = 0;

        if (isEmpty(text)) {
            return result;
        }

        result = sum(splitText(text));

        return result;
    }

    private static String[] splitText(String text) {
        return text.split("[,:]");
    }

    private static int sum(String[] splitText) {
        return Arrays.stream(splitText)
            .mapToInt(StringAddCalculator::convertNumber)
            .sum();
    }

    private static int convertNumber(String text) {
        int result = 0;
        try {
            result = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IncludeNotNumberException(text);
        }
        return result;
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }

}
