package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {
    private static final String BLANK = " ";
    private static final String PLUS_SYMBOL = "+";
    private static final String MINUS_SYMBOL = "-";
    private static final String TIMES_SYMBOL = "*";
    private static final String DIVISION_SYMBOL = "/";
    private static final int FIRST_OPERAND_INDEX = 0;
    private static final int SECOND_OPERAND_INDEX = 1;
    private static final Pattern NUMBER_OPERATOR = Pattern.compile(".*[0-9+*/-].*");
    private static final String NULL_EXCEPTION_MESSAGE = "입력값이 null입니다.";
    private static final String NUMBER_OPERATOR_EXCEPTION_MESSAGE = "입력값에 숫자나 연산기호가 없습니다.";

    public int calculate(int firstOperand, int secondOperand, String operator) {
        return Operator.findSymbol(operator).calculate(firstOperand, secondOperand);
    }

    public int makeCalculationResult(String input) {
        List<String> separatedFormula = Arrays.asList(input.split(BLANK));
        int result = Integer.parseInt(separatedFormula.get(FIRST_OPERAND_INDEX));
        for (int i = 0; i < separatedFormula.size(); i++) {
            if (separatedFormula.get(i).equals(PLUS_SYMBOL)) {
                result = calculate(result, Integer.parseInt(
                        separatedFormula.get(i + SECOND_OPERAND_INDEX)), separatedFormula.get(i));
                continue;
            }
            if (separatedFormula.get(i).equals(MINUS_SYMBOL)) {
                result = calculate(result, Integer.parseInt(
                        separatedFormula.get(i + SECOND_OPERAND_INDEX)), separatedFormula.get(i));
                continue;
            }
            if (separatedFormula.get(i).equals(TIMES_SYMBOL)) {
                result = calculate(result, Integer.parseInt(
                        separatedFormula.get(i + SECOND_OPERAND_INDEX)), separatedFormula.get(i));
                continue;
            }
            if (separatedFormula.get(i).equals(DIVISION_SYMBOL)) {
                result = calculate(result, Integer.parseInt(
                        separatedFormula.get(i + SECOND_OPERAND_INDEX)), separatedFormula.get(i));
                continue;
            }
        }
        return result;
    }

    public void validateNullException(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_EXCEPTION_MESSAGE);
        }
    }

    public void validateNumberOperatorException(String input) {
        if (!NUMBER_OPERATOR.matcher(input).find()) {
            throw new IllegalArgumentException(NUMBER_OPERATOR_EXCEPTION_MESSAGE);
        }
    }
}
