package calculator;

public class StringCalculator {

    public static int calculate(String input) {
        if (isBlank(input)) {
            return 0;
        }
        String[] tokens = input.split(",|:");
        return parseAndSum(tokens);
    }

    private static int parseAndSum(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }
}
