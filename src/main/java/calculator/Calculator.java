package calculator;

import java.util.List;

public class Calculator {
    private static final int STEP_FOR_CALCULATOR = 2;
    private static final int INITIAL_FIRST_INDEX_FOR_CALCULATOR = 0;
    private static final int INITIAL_OPERATOR_FOR_CALCULATOR = 1;
    private static final int INCREMENT_SECOND_INDEX_NUMBER_FOR_CALCULATOR = 1;
    private final String input;

    Calculator(String input) {
        this.input = input;
    }

    public double runCalculator() {
        Letters letters = new Letters(input);
        List<String> splits = letters.splitBlank();

        double totalNumber = convertStringToDouble(splits.get(INITIAL_FIRST_INDEX_FOR_CALCULATOR));
        for (int i = INITIAL_OPERATOR_FOR_CALCULATOR; i < splits.size(); i += STEP_FOR_CALCULATOR) {
            Operator operation = Operator.getOperator(splits.get(i));

            double secondNumber = convertStringToDouble(splits.get(i + INCREMENT_SECOND_INDEX_NUMBER_FOR_CALCULATOR));

            totalNumber = operation.apply(totalNumber, secondNumber);
        }
        return totalNumber;
    }

    private double convertStringToDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("연산하기위해 숫자를 입력해주세요.");
        }
    }
}
