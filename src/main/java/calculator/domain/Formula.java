package calculator.domain;

import calculator.util.FormulaUtil;
import calculator.util.Operation;
import java.util.List;

public class Formula {

    private final List<String> formular;

    public Formula(String formulaInput) {
        formular = FormulaUtil.split(formulaInput);
        isNotOperator(formular);
        isNotNumber(formular);
    }

    private static void isNotOperator(List<String> formular) {
        for (int i = 1; i < formular.size(); i += 2) {
            Operation.fromString(formular.get(i))
                .orElseThrow(() ->
                    new IllegalArgumentException("사칙연산 기호가 아닙니다.")
                );
        }
    }

    private static void isNotNumber(List<String> formular) {
        for (int i = 0; i < formular.size(); i += 2) {
            try {
                Integer.parseInt(formular.get(i));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("피연산자가 숫자가 아닙니다.");
            }
        }
    }

    public List<String> getFormula() {
        return formular;
    }
}
