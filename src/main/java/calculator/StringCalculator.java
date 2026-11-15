package calculator;

public class StringCalculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int result = 0;

        for (String number : input.split(",")) {
            result += Integer.parseInt(number);
        }

        return result;
    }
}
