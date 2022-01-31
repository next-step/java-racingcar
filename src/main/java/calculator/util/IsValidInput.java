package calculator.util;

import calculator.domain.Formular;
import calculator.view.FormulaOutput;
import java.util.List;

public class IsValidInput {

    private static final int FIRST_NUMBER = 0;
    private static final int DISTANCE = 2;

    private List<String> formular;

    public List<String> getFormular() {
        return formular;
    }

    public IsValidInput(String input) {
        isBlankOrNot(input);
        this.formular = isNotNumber(new Formular(input).getSplitedFormular());
    }


    public void isBlankOrNot(String input) {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException(FormulaOutput.ERROR_NULL_OR_EMPTY);
        }
    }

    public List<String> isNotNumber(List<String> formular) {
        int inputMaxLength = formular.size();
        for (int i = FIRST_NUMBER; i < inputMaxLength; i += DISTANCE) {
            try {
                Integer.parseInt(formular.get(i));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(FormulaOutput.ERROR_NOT_NUMBER);
            }
        }
        return formular;
    }
}
