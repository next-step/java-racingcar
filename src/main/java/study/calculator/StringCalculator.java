package study.calculator;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {
    private static final String CALCULATOR_DELIMITER = " ";
    private static final String OPERATOR_PATTERN = "([+\\-*\\/])";
    private static final String OPERAND_PATTERN = "(-?\\d+)";

    public static String getCalculationResult(String toCalculateValue){

        String[] calculateArray = splitCalculateValue(toCalculateValue);

        int calculationResult = Integer.parseInt(calculateArray[0]);

        for (int i = 1; i < calculateArray.length; i += 2) {
            String operatorValue = calculateArray[i];
            int rightValue = Integer.parseInt(calculateArray[i + 1]);
            CalculateSet calculateSet = new CalculateSet(calculationResult, rightValue);
            calculationResult = Operator.calculate(operatorValue,calculateSet);
        }

        return String.valueOf(calculationResult);
    }


    private static String[] splitCalculateValue(String toCalculateValue) {
        isEmptyInput(toCalculateValue);

        String[] input = toCalculateValue.split(CALCULATOR_DELIMITER);

        isCorrectOperator(input);

        isNumericString(input);

        isUncompletedInput(input);

        return input;
    }

    private static void isUncompletedInput(String[] input) {
        if(input[input.length-1].matches(OPERATOR_PATTERN)){
            throw new IllegalArgumentException(CustomErrorMessage.UNCOMPLETED_INPUT.getErrorMessage());
        }
    }

    private static void isCorrectOperator(String[] input) {
        IntStream.range(0, input.length)
                .filter(inputIndex -> inputIndex%2 != 0)
                .mapToObj(str -> input[str])
                .filter(filteredStr -> filteredStr.matches(OPERATOR_PATTERN))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(CustomErrorMessage.ILLEGAL_OPERATOR.getErrorMessage()));
    }

    private static void isNumericString(String[] input) {
        IntStream.range(0, input.length)
                .filter(inputIndex -> inputIndex%2 == 0)
                .mapToObj(str -> input[str])
                .filter(filteredStr -> !(filteredStr.matches(OPERAND_PATTERN)))
                .findFirst()
                .ifPresent(result -> {
                    throw new IllegalArgumentException(CustomErrorMessage.ILLEGAL_OPERAND.getErrorMessage());
                });
    }


    private static void isEmptyInput(String input) {
        if(input == null || input.length() == 0 || input.trim().length() == 0){
            throw new IllegalArgumentException(CustomErrorMessage.EMPTY_INPUT.getErrorMessage());
        }
    }
}

