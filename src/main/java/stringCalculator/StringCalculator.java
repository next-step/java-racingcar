package stringCalculator;

import stringCalculator.exception.OperatorException;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public static int calculator(String str) {
        String[] values = CustomStringUtils.split(str);
        List<Integer> operands = getOperands(values);
        List<String> operators = getOperator(values);

        return new CalculatorManager(operands, operators).getResult();
    }

    private static List<Integer> getOperands(String[] values) {
        List<Integer> operands = new ArrayList<>();
        int length = values.length;

        for (int i = 0; i < length; i += 2) {
            validateParseInt(values[i]);
            operands.add(Integer.parseInt(values[i]));
        }

        return operands;
    }

    private static List<String> getOperator(String[] values) {
        List<String> operators = new ArrayList<>();
        int length = values.length;

        for (int i = 1; i < length; i += 2) {
            validateOperator(values[i]);
            operators.add(values[i]);
        }

        return operators;
    }

    static void validateParseInt(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자 형식의 문자열이 아닙니다.");
        }
    }

    static void validateOperator(String operator) {
        if (!(Operator.ADD.getOperator().equals(operator)
                || Operator.SUBTRACT.getOperator().equals(operator)
                || Operator.MULTIPLE.getOperator().equals(operator)
                || Operator.DIVISION.getOperator().equals(operator))) {
            throw new OperatorException();
        }
    }
}
