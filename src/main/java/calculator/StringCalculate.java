package calculator;

public class StringCalculate {

    private StringCalculate() {}

    public static int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("input cannot be null or empty");
        }

        return doCalculate(input);
    }

    private static int doCalculate(String input) {
        String[] parts = input.split("\\s+");

        int result = Integer.parseInt(parts[0]);

        for (int i = 1; i < parts.length; i += 2) {
            char symbol = parts[i].charAt(0);
            int num = Integer.parseInt(parts[i + 1]);

            result = Operator.calculate(symbol, result, num);
        }

        return result;
    }
}
