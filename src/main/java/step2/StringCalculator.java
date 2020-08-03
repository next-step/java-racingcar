package step2;


import step2.collections.InputNumbers;
import step2.collections.InputOperators;
import step2.enums.Operator;

public class StringCalculator {

    private StringCalculator() {}

    public static int calculate(String expression) {
        ExpressionSeparator expressionSeparator = new ExpressionSeparator(expression);

        InputNumbers inputNumbers = expressionSeparator.getInputNumbers();
        InputOperators inputOperators = expressionSeparator.getInputOperators();

        int result = inputNumbers.get(0);

        for(int i = 1; i < inputNumbers.size() ; i++) {
            int number = inputNumbers.get(i);

            result = computeWithRightOperator(result,number, inputOperators.get(i-1));
        }

        return result;

    }

    private static int computeWithRightOperator(int one, int theOther, String operator) {
        return Operator.get(operator).compute(one, theOther);
    }


}
