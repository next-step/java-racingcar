package calculator;

/**
 * +, -, *, / 연산
 */
public class CommonCalculate{

    /**
     * 사칙연산
     * @param Operator
     * @param a
     * @param b
     * @return
     */
    public static int commonCalculate(CalculatorParamValue paramValue){
        int returnValue = 0;

        switch(paramValue.getOperator()) {
            case '+':
                returnValue = Opserator.ADD.getResult(paramValue);
                break;
            case '-':
                returnValue = Opserator.SUB.getResult(paramValue);
                break;
            case '*':
                returnValue = Opserator.MUL.getResult(paramValue);
                break;
            case '/':
                returnValue = Opserator.DIV.getResult(paramValue);
                break;
        }

        return returnValue;
    }
}
