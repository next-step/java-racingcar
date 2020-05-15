package calculator;

public class StringCalculator {

    private final int MINIMUM_COUNT_FORMULA_ELEMENT = 3;

    private String[] formulaElements;

    public StringCalculator(String formula) {
        checkNullOrEmpty(formula);
        formulaElements = formula.split(" ");
        checkElementCountOfInvalid(formulaElements);
    }

    public float calculate() throws ArithmeticException {
        Operand result = Operand.valueOf(formulaElements[0]);
        for(int i = 1 ; i < formulaElements.length ; i += 2) {
            Operator operator = Operator.getOperator(formulaElements[i]);
            result = result.calculate(operator, Operand.valueOf(formulaElements[i+1]));
        }
        return result.getNumber();
    }

    private void checkNullOrEmpty(String str) {
        if(str == null || str.isEmpty()) {
            throw new IllegalArgumentException("string is null.");
        }
    }

    private void checkElementCountOfInvalid(String[] formulaElements) {
        int length = formulaElements.length;
        if (length < MINIMUM_COUNT_FORMULA_ELEMENT || isEven(length)) {
            throw new IllegalArgumentException("There are errors in the number of operators and operands.");
        }
    }

    private boolean isEven(int number) {
        return (number % 2 == 0);
    }
}
