package calculator;

public class InputValue {
    private static final String PREFIX_DELIMITER_INDICATOR = "//";
    private static final String PREFIX_FORMULA_INDICATOR = "\n";
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final int INDEX_OF_CUSTOM_DELIMITER = 2;

    private Delimiter delimiter;
    private Formula formula;

    public InputValue(String input) {
        this.delimiter = new Delimiter(extractDelimiterWord(input));
        this.formula = new Formula(extractFormulaWord(input));
    }

    private String extractDelimiterWord(String input) {
        if (input.startsWith(PREFIX_DELIMITER_INDICATOR)) {
            return input.substring(INDEX_OF_CUSTOM_DELIMITER, input.indexOf(PREFIX_FORMULA_INDICATOR));
        }
        return DEFAULT_DELIMITER;
    }

    private String extractFormulaWord(String input) {
        if (input.startsWith(PREFIX_DELIMITER_INDICATOR)) {
            return input.split(PREFIX_FORMULA_INDICATOR)[1];
        }
        return input;
    }

    public String getDelimiterWord() {
        return delimiter.getDelimiter();
    }

    public String getFormula() {
        return formula.getFormulaInput();
    }

    public int getResult() {
        Numbers numbers = formula.getNumbers(delimiter);
        return numbers.add();
    }
}
