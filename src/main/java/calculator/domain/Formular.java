package calculator.domain;

import calculator.view.FormulaOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Formular {

    private static final int FIRST_NUMBER = 0;
    private static final int DISTANCE = 2;
    private final static String SPLIT_EMPTY_SPACE_NUMBER = " ";
    private List<String> splitedFormular;

    public Formular(String expressions) {
        isBlankOrNot(expressions);
        this.splitedFormular = isNotNumber(new ArrayList<>(Arrays.asList(expressions.split(
            SPLIT_EMPTY_SPACE_NUMBER))));
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

    public List<String> getSplitedFormular() {
        return Collections.unmodifiableList(splitedFormular);
    }

}
