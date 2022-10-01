package calculator;

public class StringNumberCalculator {

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }
        return new PositiveInteger(input).intValue();
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

}
