package calculator;

import calculator.operation.Operator;
import calculator.validation.CalculatorValidator;
import calculator.value.CalculatorValue;

public class Calculator {
    private static final String DELIMITER = " ";

    public Long execute(String input) {
        CalculatorValidator.checkInputEmpty(input);
        return calculate(input);
    }

    private Long calculate(String input) {
        String[] inputArray = input.split(DELIMITER);

        Long total = Long.parseLong(inputArray[0]);
        for (int i = 1; i < inputArray.length; i += 2) {
            String operator = inputArray[i];
            Long operand2 = Long.parseLong(inputArray[i + 1]);

            total = Operator.calculate(CalculatorValue.of(operator, total, operand2));
        }
        return total;
    }
}
