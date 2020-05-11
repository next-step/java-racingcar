package stringCalculator;

import stringCalculator.exception.EmptyInputException;
import stringCalculator.operator.FourArithmeticOperator;
import stringCalculator.operator.Operator;

public class StringCalculator {
    private static final String DELIMITER = " ";

    public int main(String input) {
        validateEmptyInput(input);

        String[] values = input.split(DELIMITER);

        int total = Integer.parseInt(values[0]);
        Operator operator = new FourArithmeticOperator();

        for (int i = 1; i < values.length; i += 2) {
            String operation = values[i];
            int target = Integer.parseInt(values[i + 1]);

            total = operator.calculate(total, target, operation);
        }

        return total;
    }

    private void validateEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new EmptyInputException();
        }
    }
}
