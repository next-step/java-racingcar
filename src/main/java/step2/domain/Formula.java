package step2.domain;

import java.util.Arrays;

public class Formula {
    private static final String WHITE_SPACE = " ";
    private static final int FORMULA_MIN_LENGTH = 3;
    private String[] elements = new String[]{};

    private Formula(String value) {
        String[] elements = splitElements(value);
        checkFormulaLength(elements);
        checkValidFormula(elements);
        this.elements = elements;
    }

    public static Formula of(String value) {
        checkFormulaEmpty(value);
        return new Formula(value);
    }

    public int calculate() {
        int currentResult = Integer.parseInt(elements[0]);
        for (int idx = 1; idx < elements.length; idx += 2) {
            String operator = elements[idx];
            int nextNumber = Integer.parseInt(elements[idx+1]);
            currentResult = calculate(currentResult, Operator.of(operator), nextNumber);
        }
        return currentResult;
    }

    private int calculate(int firstNumber, Operator operator, int secondNumber) {
        return operator.calculate(firstNumber, secondNumber);
    }

    private String[] splitElements(String value) {
        return value.split(WHITE_SPACE);
    }

    private static void checkFormulaEmpty(String formula) {
        if (formula == null || "".equals(formula) || " ".equals(formula)) {
            throw new IllegalArgumentException("수식은 null 이나 빈 공백을 허용하지않습니다.");
        }
    }

    private void checkFormulaLength(String[] splitFormula) {
        if (splitFormula.length < FORMULA_MIN_LENGTH) {
            throw new IllegalArgumentException("최소 1개 이상의 수식을 입력해야합니다.");
        }
    }

    private void checkValidFormula(String[] splitFormula) {
        Arrays.stream(splitFormula)
                .filter(element -> !Operator.contains(element))
                .filter(element -> !isNumeric(element))
                .findAny()
                .ifPresent(element -> {
                    throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어있습니다.");
                });
    }

    private boolean isNumeric(String element) {
        boolean result = true;
        for (char c : element.toCharArray()) {
            if (!Character.isDigit(c)) {
                result = false;
            }
        }
        return result;
    }
}
