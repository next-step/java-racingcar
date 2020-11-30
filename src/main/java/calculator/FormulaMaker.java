package calculator;

public class FormulaMaker {
    private static final String SPACE = " ";
    private static final int MIN_LENGTH = 3;

    private static final String NULL_OR_EMPTY_EXCEPTION = "입력값이 비어있습니다.";
    private static final String WRONG_EXPRESSION_EXCEPTION = "계산식이 최소 길이를 만족하지 않습니다.";
    private static final String WRONG_SIGN_EXCEPTION = "계산 부호 오류입니다.";

    private String[] formula;

    public FormulaMaker(String inputValue) {
        this.formula = inputValue.split(SPACE);

        split(inputValue);
        checkValidation(inputValue);
    }

    private void split(String inputValue) {
        this.formula = inputValue.split(SPACE);
    }

    private void checkValidation(String inputValue) {
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
            throw new IllegalArgumentException(NULL_OR_EMPTY_EXCEPTION);
        }
    }

    private void checkFormulaValidation(String[] expression) {
        if (expression.length < MIN_LENGTH) {
            throw new IllegalArgumentException(WRONG_EXPRESSION_EXCEPTION);
        }
    }

    private void checkSign(String symbol) {
        try {
            Operator operator = Operator.getOperator(symbol);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(WRONG_SIGN_EXCEPTION);
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
