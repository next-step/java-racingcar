package calculator;

import calculator.domain.Operator;
import java.util.List;
import java.util.regex.Pattern;

public class Validator {

    private static Validator instance;
    private String formula;

    private Validator(String formula) {
        this.formula = formula;
    }

    public static Validator getInstance(String formula) {
        if (instance == null) {
           instance = new Validator(formula);
        }
        return instance;
    }

    public void validateFormulaIsNull() {
        // 입력 null X
        if (formula == null) {
            throw new IllegalArgumentException("입력은 비어있을 수 없습니다.");
        }
    }

    public void validateFormulaOperator() {
        // 사칙연산 기호 이외의 것 X
        boolean matches = Pattern.matches("^[0-9+\\-*/ ]*$", formula);
        if (!matches) {
            throw new IllegalArgumentException("숫자 및 사칙연산자, 공백 기호 이외에는 입력할 수 없습니다.");
        }
    }

    public void validateFormulaHasOneBlank() {
        // 공백 2자 이상 X
        if (formula.contains("  ")) {
            throw new IllegalArgumentException("공백이 두 자 이상일 수 없습니다.");
        }
    }

    public void validateOrder(List<String> parsed) {
    }
}
