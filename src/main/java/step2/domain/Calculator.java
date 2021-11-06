package step2.domain;

public class Calculator {
    private Formula formula;

    private Calculator() {
    }

    public static Calculator create() {
        return new Calculator();
    }

    public void input(Formula formula) {
        this.formula = formula;
    }

    public boolean isFormulaEmpty() {
        return formula == null;
    }

    public int calculate() {
        return formula.calculate();
    }
}
