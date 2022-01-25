package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Formula {

    private final List<String> formular;

    public Formula(String formular) {
        List<String> fomularSplit = new ArrayList<>(Arrays.asList(formular.split(" ")));
        isNotOperator(fomularSplit);
        isNotNumber(fomularSplit);

        this.formular = fomularSplit;
    }

    private static void isNotOperator(List<String> formular) {
        final int operatorIndex = 2;
        for (int i = 1; i < formular.size(); i += operatorIndex) {
            Operation.from(formular.get(i))
                .orElseThrow(() ->
                    new IllegalArgumentException("사칙연산 기호가 아닙니다.")
                );
        }
    }

    private static void isNotNumber(List<String> formular) {
        final int numberIndex = 2;
        for (int i = 0; i < formular.size(); i += numberIndex) {
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
