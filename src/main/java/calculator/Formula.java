package calculator;

public class Formula {

    private final String[] formula;
    private static final String FORMULA_SPLITTER = " ";

    public Formula(String formula) {
        this.formula = formula.split(FORMULA_SPLITTER);
    }

    String[] getFormula() {
        return formula;
    }

    public enum ConfigurationType {
        OPERATOR, NUMBER, NONE;

        public static boolean isValidCalculatorSequence(ConfigurationType prevType, ConfigurationType currentType) {
            return prevType == NONE && currentType == NUMBER
                    || prevType == OPERATOR && currentType == NUMBER
                    || prevType == NUMBER && currentType == OPERATOR;
        }
    }

}

