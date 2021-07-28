package study.step2;

public class Calculator {

    private static final String emptyStr = " ";

    private int calculatorResult;
    private String[] calculatorInputStrings;

    public Calculator() {
        calculatorResult = 0;
    }

    public int calculate(String calcStr) {

        if (calcStr == null || calcStr.length() == 0) {
            throw new IllegalArgumentException("Input value is null or empty");
        }

        calculateInit(calcStr);

        for (int idx = 1; idx < getCalculatorInputStrings().length; idx++) {
            getOperatorResult(idx);
        }

        return calculatorResult;
    }

    private void calculateInit(String calcStr) {
        setCalculatorInputStrings(calcStr.split(emptyStr));
        setCalculatorResult(Integer.parseInt(getCalculatorInputStrings()[0]));
    }

    private void getOperatorResult(int idx) {

        String operand = getCalculatorInputStrings()[idx];

        if (Operator.isOperator(operand)) {
            calculatorResult = Operator.valueOfStr(operand).calculate(calculatorResult, Integer.parseInt(getCalculatorInputStrings()[idx + 1]));
        }
    }

    public void setCalculatorInputStrings(String[] calculatorInputStrings) {
        this.calculatorInputStrings = calculatorInputStrings;
    }

    public String[] getCalculatorInputStrings() {
        return calculatorInputStrings;
    }

    public int getCalculatorResult() {
        return calculatorResult;
    }

    public void setCalculatorResult(int calculatorResult) {
        this.calculatorResult = calculatorResult;
    }
}
