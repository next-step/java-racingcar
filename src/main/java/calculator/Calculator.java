package calculator;

import calculator.util.StringUtils;

public class Calculator {
    private static final String DELIMITER = " ";

    public double calculate(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_STRING);
        }

        String[] inputArray = input.split(DELIMITER);

        double firstNumber = StringUtils.getNumber(inputArray[0]);
        for (int i = 1; i < inputArray.length - 1; i += 2) {
            double secondNumber = StringUtils.getNumber(inputArray[i + 1]);

            firstNumber = Operation.of(inputArray[i]).calculate(firstNumber, secondNumber);
        }

        return firstNumber;
    }
}
