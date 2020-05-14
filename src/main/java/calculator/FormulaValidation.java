package calculator;

public class FormulaValidation {

    private final String[] formula;

    private final int MINIMUM_COUNT_FORMULA_ELEMENT = 3;
    private final int NUMBER_DETERMINE_ODD_OR_EVEN = 2;

    public FormulaValidation(String[] str) {
        formula = str;
    }

    public String[] check() throws IllegalArgumentException {
        if(isNullOrEmpty(formula)) {
            throw new IllegalArgumentException("formula is empty or null");
        }

        if(isElementCountOfInvalid(formula)) {
            throw new IllegalArgumentException("There are errors in the number of operators and operands.");
        }

        if(isOrderOfInvalid(formula)) {
            throw new IllegalArgumentException("There is an error in the order of operators and operands.");
        }
        return formula;
    }

    private boolean isNullOrEmpty(String[] str) {
        return str == null || str.length == 0;
    }

    private boolean isOrderOfInvalid(String[] formulaElements) {
        for(int i = 0 ; i < formulaElements.length ; i++) {
            if(isOrderOfInvalidOperand(i, formulaElements[i]) ||
                isOrderOfInvalidOperator(i, formulaElements[i]))
            {
                return true;
            }
        }
        return false;
    }

    private boolean isElementCountOfInvalid(String[] formulaElements) {
        int length = formulaElements.length;
        return (length < MINIMUM_COUNT_FORMULA_ELEMENT || length % NUMBER_DETERMINE_ODD_OR_EVEN == 0);
    }

    private boolean isOrderOfInvalidOperand(int index, String element) {
        return index % NUMBER_DETERMINE_ODD_OR_EVEN == 0 && !Operand.isOperand(element);
    }

    private boolean isOrderOfInvalidOperator(int index, String element) {
        return index % NUMBER_DETERMINE_ODD_OR_EVEN == 1 && !Operator.isOperatorSymbol(element);
    }
}
