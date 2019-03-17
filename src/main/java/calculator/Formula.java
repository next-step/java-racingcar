package calculator;

public class Formula {
    private String formula;

    public Formula(String formula) {
        this.formula = formula;
    }

    public String getFormulaInput() {
        return this.formula;
    }

    public Numbers getNumbers(Delimiter delimiter) {
        return new Numbers(formula.split(delimiter.getDelimiter()));
    }
}
