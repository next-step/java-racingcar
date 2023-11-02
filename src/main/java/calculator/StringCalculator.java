package calculator;

public class StringCalculator {
    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\\:";
        if (input.matches("\\/\\/\\D+\\\n.*")) {
            delimiter = input.split("\\//|\\\n")[1];
            input = input.replaceFirst("\\/\\/\\D+\\\n", "");
        }

        String[] elements = input.split(delimiter);
        int sum = 0;
        for (int i = 0; i < elements.length; i++) {
            sum += Integer.parseInt(elements[i]);
        }
        return sum;
    }
}
