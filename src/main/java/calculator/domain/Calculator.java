package calculator.domain;

import java.util.List;

public class Calculator {
    private static final List<String> DIVS = Operator.getDivs();
    private double beforeNum = 0;
    private double nextNum = 0;

    public void setBeforeNum(double beforeNum) {
        this.beforeNum = beforeNum;
    }

    public void setNextNum(double nextNum) {
        this.nextNum = nextNum;
    }

    public double getBeforeNum() {
        return beforeNum;
    }

    public double getNextNum() {
        return nextNum;
    }

    void validOperatorDiv(String div) {
        if (!DIVS.contains(div)) {
            throw new IllegalArgumentException();
        }
    }

    public double calculate(String div) {
        validOperatorDiv(div);
        return Operator.getOperator(div).calculate(beforeNum, nextNum);
    }

}
