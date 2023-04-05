package study;

public class StringAdditionCalculator {
    public static int splitAndSum(String input) {
        if(isNullOrEmpty(input)) {
            return 0;
        }

        return Integer.parseInt(input);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
