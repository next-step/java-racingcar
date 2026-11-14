package calculator;

public class StringCalculator {

    public static int calculate(String input) {
        if (isBlank(input)) {
            return 0;
        }

        return 0;
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }
}
