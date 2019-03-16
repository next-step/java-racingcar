package calculator;

public class InputValue {
    private Delimiter delimiter;
    private Formula formula;

    public InputValue(String input) {
        this.delimiter = new Delimiter(extractDelimiterWord(input));
        this.formula = new Formula(extractFormulaWord(input));
    }

    private String extractDelimiterWord(String input) {
        if (input.startsWith("//")) {
            return input.substring(2, input.indexOf("\n"));
        }
        return ",|:";
    }

    private String extractFormulaWord(String input) {
        if (input.startsWith("//")) {
            return input.split("\n")[1];
        }
        return input;
    }

    public String getDelimiterWord() {
        return delimiter.getDelimiter();
    }

    public String getFormula() {
        return formula.getFormulaInput();
    }
}
