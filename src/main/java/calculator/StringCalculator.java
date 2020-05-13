package calculator;

public class StringCalculator {

    private String[] formulaElements;

    public StringCalculator(String formula) {
        checkNullOrEmpty(formula);
        formulaElements = formula.split(" ");
        checkOrderFormula(formulaElements);
    }

    public float calculate() {
        Operand result = new Operand(formulaElements[0]);
        for(int i = 1 ; i < formulaElements.length ; i += 2) {
            Operator operator = Operator.getOperator(formulaElements[i]);
            result = result.calculate(operator, new Operand(formulaElements[i+1]));
        }
        return result.getNumber();
    }

    private void checkNullOrEmpty(String str) throws IllegalArgumentException {
        if(str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Argument is null or empty.");
        }
    }

    private void checkOrderFormula(String[] formulaElements) throws IllegalArgumentException {
        checkFormulaElementCount(formulaElements);

        for(int i = 0 ; i < formulaElements.length ; i++) {
            checkOrderOperand(i, formulaElements[i]);
            checkOrderOperator(i, formulaElements[i]);
        }
    }

    private void checkFormulaElementCount(String[] formulaElements) {
        if(formulaElements.length % 2 == 0) {
            throw new IllegalArgumentException("There are errors in the number of operators and operands.");
        }
    }

    private void checkOrderOperand(int index, String element) {
        if(index % 2 == 0 && !Operand.isOperand(element)) {
            throw new IllegalArgumentException("The number must come at index " + index);
        }
    }

    private void checkOrderOperator(int index, String element) {
        if(index % 2 == 1 && !Operator.isOperatorSymbol(element)) {
            throw new IllegalArgumentException("The operator must come at index " + index);
        }
    }
}
