package calculator;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {

    private final String formula;

    private static Validator instance;

    private Validator(String formula) {
        this.formula = formula;
    }

    public static Validator getInstance(String formula) {
        if (instance == null) {
           instance = new Validator(formula);
        }
        return instance;
    }

    public void validateFormulaIsEmpty() {
        if ("".equals(formula.trim())) {
            throw new IllegalArgumentException("입력은 비어있을 수 없습니다.");
        }
    }

    public void validateFormulaIsNull() {
        if (formula == null) {
            throw new IllegalArgumentException("입력은 비어있을 수 없습니다.");
        }
    }

    public void validateFormulaOperator() {
        boolean matches = Pattern.matches("^[0-9+\\-*/ ]*$", formula);
        if (!matches) {
            throw new IllegalArgumentException("숫자 및 사칙연산자, 공백 기호 이외에는 입력할 수 없습니다.");
        }
    }

    public void validateFormulaHasOneBlank() {
        if (formula.contains("  ")) {
            throw new IllegalArgumentException("공백이 두 자 이상일 수 없습니다.");
        }
    }

    public void validateOrder(List<String> parsed) {
        int index;
        for (index = 0; index < parsed.size() - 2; index += 2) {
            validateNumber(parsed.get(index));
            validateOperator(parsed.get(index + 1));
        }
        validateNumber(parsed.get(index));
    }


    private void validateNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 연산식입니다.");
        }
    }

    private void validateOperator(String s) {
        if (!Pattern.matches(".*[+\\-*/].*", s)) {
            throw new IllegalArgumentException("유효하지 않은 연산기호입니다.");
        }
    }

}
