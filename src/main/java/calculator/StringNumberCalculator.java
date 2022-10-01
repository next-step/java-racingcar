package calculator;

public class StringNumberCalculator {

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }
        PositiveInteger positiveInteger = new PositiveInteger(input);
        return 1;
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

}
