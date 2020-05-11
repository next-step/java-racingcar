package calculator;

import java.util.List;

public class Calculator {
    public static final int ZERO_NUMBER = 0;
    private static final int STEP_FOR_CALCULATOR = 2;
    private static final int INITIAL_FIRST_INDEX_FOR_CALCULATOR = 0;
    private static final int INITIAL_OPERATOR_FOR_CALCULATOR = 1;
    private static final int INCREMENT_SECOND_INDEX_NUMBER_FOR_CALCULATOR = 1;

    static void checkOperationSign(String operation) {
        if (!Operator.isOperator(operation)) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다. 사칙연산부호를 입력해주세요.");
        }
    }

    static void checkBlack(String inputData) {
        if (inputData == null || inputData.trim().isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }

    static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("연산하기위해 숫자를 입력해주세요.");
        }
    }

    static double convertStringToDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("연산하기위해 숫자를 입력해주세요.");
        }
    }

    static double runCalculator(String input) {
        checkBlack(input);
        List<String> splits = Letters.convertStringToStrings(input);

        double totalNumber = convertStringToDouble(splits.get(INITIAL_FIRST_INDEX_FOR_CALCULATOR));
        for (int i = INITIAL_OPERATOR_FOR_CALCULATOR; i < splits.size(); i += STEP_FOR_CALCULATOR) {
            String symbol = splits.get(i);
            Operator.checkOperationSign(symbol);
            Operator operation = Operator.getOperator(symbol);

            double secondNumber = convertStringToDouble(splits.get(i + INCREMENT_SECOND_INDEX_NUMBER_FOR_CALCULATOR));

            totalNumber = operation.apply(totalNumber, secondNumber);
        }
        return totalNumber;
    }
}
