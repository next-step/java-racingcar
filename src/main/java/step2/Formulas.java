package step2;

import java.util.Objects;

public class Formulas {
    private static final String delimiter = " ";

    private String[] formulas;

    public Formulas(String formulas) {
        checkIsNullOrEmpty(formulas);
        this.formulas = formulas.split(delimiter);
    }

    private void checkIsNullOrEmpty(String formulas) {
        if (Objects.isNull(formulas) || formulas.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public String[] getFormulas() {
        return formulas;
    }
}
