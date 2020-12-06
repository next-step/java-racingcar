package calculator;

public class StringCalculate {

    private StringCalculate() {}

    private static void verifyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("input cannot be null or empty");
        }
    }

    private static void verifyInputSize(String[] parts) {
        if (parts.length % 2 == 0) {
            throw new IllegalArgumentException("invalid input value");
        }
    }

    public static int calculate(String input) {
        verifyInput(input);
        String[] parts = input.split("\\s+");
        verifyInputSize(parts);

        return doCalculate(parts);
    }

    private static int doCalculate(String[] parts) {
        int result = Integer.parseInt(parts[0]);

        for (int i = 1; i < parts.length; i += 2) {
            char symbol = parts[i].charAt(0);
            int num = Integer.parseInt(parts[i + 1]);

            result = Operator.calculate(symbol, result, num);
        }

        return result;
    }
}
