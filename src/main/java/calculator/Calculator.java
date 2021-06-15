package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {
    private static final String BLANK = " ";
    private static final int INITIAL_VALUE = 0;
    private static final int FIRST_OPERATOR_INDEX = 1;
    private static final int FIRST_OPERAND_INDEX = 1;
    private static final int SECOND_OPERAND_INDEX = 1;
    private static final int NEXT_FORMULA_INDEX = 2;
    private static final Pattern NUMBER_OPERATOR = Pattern.compile(".*[0-9+*/-].*");
    private static final String NULL_EXCEPTION_MESSAGE = "입력값이 null입니다.";
    private static final String NUMBER_OPERATOR_EXCEPTION_MESSAGE = "입력값에 숫자나 연산기호가 없습니다.";

    public int makeCalculationResult(String input) {
        validateInputNull(input);
        validateInputNotNumberOperator(input);
        List<String> separatedFormulas = Arrays.asList(input.split(BLANK));
        int result = INITIAL_VALUE;
        int separatedFormulaIndex = FIRST_OPERATOR_INDEX;
        for (String separatedFormula : separatedFormulas) {
            try {
                String operator = Operator.findSymbol(separatedFormulas.get(separatedFormulaIndex))
                        .getSymbol();
                result = calculate(Integer.parseInt(separatedFormulas.get(
                        separatedFormulaIndex - FIRST_OPERAND_INDEX))
                        , Integer.parseInt(separatedFormulas.get(
                                separatedFormulaIndex + SECOND_OPERAND_INDEX)), operator);
                separatedFormulaIndex += NEXT_FORMULA_INDEX;
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        return result;
    }

    private void validateInputNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_EXCEPTION_MESSAGE);
        }
    }

    private void validateInputNotNumberOperator(String input) {
        if (!NUMBER_OPERATOR.matcher(input).find()) {
            throw new IllegalArgumentException(NUMBER_OPERATOR_EXCEPTION_MESSAGE);
        }
    }

    private int calculate(int firstOperand, int secondOperand, String operator) {
        return Operator.findSymbol(operator).calculate(firstOperand, secondOperand);
    }
}
