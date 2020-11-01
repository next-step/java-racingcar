package calculator;

import java.util.List;

/**
 * 계산에 필요한 파라미터를 저장
 */
public class CalculatorParamValue {

    private String paramText; // text
    private int Listindex;  // 사칙연산 idnex
    private List<OperatorOrder> list; // 사칙연산들
    private int returnValue; // 계산된 결과값
    private int firstValue;
    private int secondValue;
    private char operator;

    CalculatorParamValue(final String paramText, final int Listindex, final int returnValue, final List<OperatorOrder> list){
        this.paramText = paramText;
        this.Listindex = Listindex;
        this.list = list;
        this.returnValue = returnValue;
    }

    CalculatorParamValue(final char operator, final int firstValue, final int secondValue){
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.operator = operator;
    }

    public int getFirstValue() {
        return firstValue;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public char getOperator() {
        return operator;
    }

    public int getReturnValue() {
        return returnValue;
    }

    public String getParamText() {
        return paramText;
    }

    public int getListindex() {
        return Listindex;
    }

    public List<OperatorOrder> getList() {
        return list;
    }
}
