package calculator.util;

import calculator.ui.FormulaOutput;
import java.util.List;

public class IsValidInput {
    private static final int FIRST_OPERATOR = 1;
    private static final int FIRST_NUMBER = 0;
    private static final int DISTANCE = 2;

    public static void isBlankOrNot(String input) {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException(FormulaOutput.ERROR_NULL_OR_EMPTY);
        }
    }

    public static void isNotNumber(List<String> formular) {
        int inputMaxLength = formular.size();
        for (int i = FIRST_NUMBER; i < inputMaxLength; i += DISTANCE) {
            try {
                Integer.parseInt(formular.get(i));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(FormulaOutput.ERROR_NOT_NUMBER);
            }
        }
    }
}
