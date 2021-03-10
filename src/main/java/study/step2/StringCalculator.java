package study.step2;

public class StringCalculator {

    private static final String DELIMITER = " ";

    public int calculate(String input) {
        validate(input);

        String[] str = input.split(DELIMITER);
        int result = Integer.parseInt(str[0]);
        for (int index = 1; index < str.length - 1; index += 2) {
            result = Operator.execute(result, str[index], Integer.parseInt(str[index + 1]));
        }

        return result;
    }

    private void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException(CalculatorError.INPUT_NULL);
        }

        if (input.isEmpty() || input.trim().isEmpty()) {
            throw new IllegalArgumentException(CalculatorError.INPUT_BLANK);
        }
    }
}
