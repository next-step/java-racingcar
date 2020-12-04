package calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorFormula {
    private static final String WRONG_INPUT = "입력값이 잘못되었습니다.";
    private final List<Integer> numbers = new ArrayList<>();
    private final List<Operator> operators = new ArrayList<>();;

    public CalculatorFormula(String[] inputArray) {
        inputValidation(inputArray);
        for (int i = 0; i < inputArray.length; i += 2) {
            numbers.add(Integer.parseInt(inputArray[i]));
            int operatorsIndex = i + 1;
            if (operatorsIndex != inputArray.length) {
                operators.add(Operator.getOperator(inputArray[operatorsIndex]));
            }
        }
    }

    public int getNumber(int index) {
        return numbers.get(index);
    }
    public Operator getOperator(int index) {
        return operators.get(index);
    }

    private void inputValidation(String[] input) {
        if (CalculatorFormula.isNull(input) || CalculatorFormula.isEmpty(input) ||
            CalculatorFormula.isNotConvertToInt(input) || CalculatorFormula.isNotAble(input)) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }
    }

    private static boolean isNull(String[] inputArray) {
        return inputArray == null;
    }

    private static boolean isEmpty(String[] inputArray) {
        return inputArray.length == 0;
    }

    private static boolean isNotConvertToInt(String[] inputArray) {
        for (int i = 0; i < inputArray.length; i += 2) {
            if(!Character.isDigit(inputArray[i].charAt(0))){
                return true;
            }
        }
        return false;
    }

    private static boolean isNotAble(String[] inputArray) {
        return inputArray.length % 2 == 0;
    }
}
