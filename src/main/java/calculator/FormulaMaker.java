package calculator;

public class FormulaMaker {
    private static final String SPACE = " ";
    private static final int MIN_LENGTH = 3;

    private static final IllegalArgumentException nullOrEmptyException = new IllegalArgumentException();
    private static final IllegalArgumentException wrongExpressionException = new IllegalArgumentException();
    private static final IllegalArgumentException wrongSignException = new IllegalArgumentException();

    private String inputValue;
    private String[] formula;

    public void split(String inputValue) {
        this.inputValue = inputValue;
        this.formula = inputValue.split(SPACE);
    }

    public void checkValidation() {
        checkInputValidation(inputValue);
        checkFormulaValidation(formula);

        for (int i = 1; i < formula.length; i += 2) {
            checkSign(formula[i]);
            checkIntValue(formula[i + 1]);
        }
    }

    public String[] getFormula() {
        return formula;
    }

    private void checkInputValidation(String input) {
        if (input == null || input.length() == 0) {
            throw nullOrEmptyException;
        }
    }

    private void checkFormulaValidation(String[] expression) {
        if (expression.length < MIN_LENGTH) {
            throw wrongExpressionException;
        }
    }

    private void checkSign(String symbol) {
        try {
            Operator operator = Operator.getOperator(symbol);
        } catch (IllegalArgumentException e) {
            throw wrongSignException;
        }
    }

    private void checkIntValue(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
}
