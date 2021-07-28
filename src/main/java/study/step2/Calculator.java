package study.step2;

import study.step2.Intf.CalculatorIntf;

public class Calculator implements CalculatorIntf {


    int result;
    private String[] calcStrArry;


    public Calculator() {
        result = 0;
    }

    @Override
    public int calculate(String calcStr) {

        if (calcStr == null || calcStr.length() == 0) {
            throw new IllegalArgumentException("Input value is null or empty");
        }

        calculateInit(calcStr);

        for (int idx = 1; idx < getCalcStrArry().length; idx++) {
            getOperatorResult(idx);
        }

        return result;
    }

    private void calculateInit(String calcStr) {
        setCalcStrArry(calcStr.split(Constants.emptyStr));
        setResult(Integer.parseInt(getCalcStrArry()[0]));
    }

    private void getOperatorResult(int idx) {

        String operand = getCalcStrArry()[idx];

        if (Operator.isOperator(operand)) {
            result = Operator.valueOfStr(operand).calculate(result, Integer.parseInt(getCalcStrArry()[idx + 1]));
        }
    }

    public void setCalcStrArry(String[] calcStrArry) {
        this.calcStrArry = calcStrArry;
    }

    public String[] getCalcStrArry() {
        return calcStrArry;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
