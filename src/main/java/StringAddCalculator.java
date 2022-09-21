import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String input) throws Exception {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        if (isNumeric(input)) {
            return Integer.parseInt(input);
        }

        String[] numbers = input.split(",");

        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }

    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
