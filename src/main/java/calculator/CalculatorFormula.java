package calculator;

import java.util.Arrays;
import java.util.List;

public class CalculatorFormula {
    private static final String WRONG_INPUT = "입력값이 잘못되었습니다.";
    private final List<String> formula;

    public CalculatorFormula(String input) {
        inputValidation(input);
        formula = Arrays.asList(input.split(" "));
    }

    public int getNumber(int index) {
        int numberIndex = index * 2;
        return Integer.parseInt(formula.get(numberIndex));
    }
    public String getOperator(int index) {
        int operatorIndex = index * 2 -1;
        return formula.get(operatorIndex);
    }

    private void inputValidation(String input) {
        if (CalculatorFormula.isNull(input)) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }
        if (CalculatorFormula.isEmpty(input)) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }
        if (CalculatorFormula.isNotConvertToInt(input)) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }
    }

    private static boolean isNull(String input) {
        return input == null;
    }

    private static boolean isEmpty(String input) {
        return input.trim().isEmpty();
    }

    private static boolean isNotConvertToInt(String input) {
        for (int i = 0; i < input.length(); i += 4) {
            if(!Character.isDigit(input.charAt(i))){
                return true;
            }
        }
        return false;
    }
}
