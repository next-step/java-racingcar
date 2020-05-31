package calculator;

public class StringCalculator {

    public int apply(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException();
        }

        String[] strArray = split(input);
        int sum = toInt(strArray[0]);

        for (int i = 1; i < strArray.length; i += 2) {
            try {
                String operator = strArray[i];
                int number = toInt(strArray[i + 1]);
                sum = calculate(operator, sum, number);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
        }
        return sum;
    }

    private static int calculate(String operator, int sum, int number) {
        return CalculatorSelector.getCalculator(operator).calculate(sum, number);
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    private boolean isBlank(String input) {
        return input == null || input.equals("");
    }

    private String[] split(String value) {
        return value.split(" ");
    }
}