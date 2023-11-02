package calculator;

public class StringCalculator {
    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] elements = input.split(",|\\:");
        int sum = 0;
        for (int i = 0; i < elements.length; i++) {
            sum += Integer.parseInt(elements[i]);
        }
        return sum;
    }
}
