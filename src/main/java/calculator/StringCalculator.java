package calculator;

public class StringCalculator {

    private String[] formulaElements;

    public StringCalculator(String formula) {
        if(isNullOrEmpty(formula)) {
            throw new IllegalArgumentException("string is null.");
        }

        String[] formulaBeforeChecking = formula.split(" ");
        formulaElements = new FormulaValidation(formulaBeforeChecking).check();
    }

    public float calculate() throws ArithmeticException {
        Operand result = Operand.valueOf(formulaElements[0]);
        for(int i = 1 ; i < formulaElements.length ; i += 2) {
            Operator operator = Operator.getOperator(formulaElements[i]);
            result = result.calculate(operator, Operand.valueOf(formulaElements[i+1]));
        }
        return result.getNumber();
    }

    private boolean isNullOrEmpty(String str) {
        return (str == null || str.isEmpty());
    }



}
