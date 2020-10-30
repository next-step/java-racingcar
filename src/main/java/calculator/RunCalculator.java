package calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * 계산기
 */
public class RunCalculator {

    /**
     * 계산 시작
     */
    public static int runCalculator(final String paramText){
        paramTextCheck(paramText);
        String refineText = paramText.replaceAll(" ", "");
        List<OperatorOrder> list = operatorDivision(refineText);
        int returnValue = stepToCalculatorRun(refineText, list);

        return returnValue;
    }

    /**
     * 계산에 사용될 Text를 Check
     * @param paramText
     * @return 정제된 문자열
     */
    public static void paramTextCheck(final String paramText){
        nullOrEmptyCheck(paramText);
        blankCheck(paramText);
    }

    private static void nullOrEmptyCheck(String paramText) {
        if(paramText == null || paramText.length() == 0) {
            throw new IllegalArgumentException("연산할 Text가 null");
        }
    }

    public static void blankCheck(String paramText) {
        if(paramText.trim().length() == 0) {
            throw new IllegalArgumentException("연살한 Text가 empry");
        }
    }

    /**
     * 연산자 체크
     * @param Operator
     * @return
     */
    public static void paramOperatorCheck(final char paramOperator){
        if( !(paramOperator == '+' || paramOperator == '-' || paramOperator == '/' || paramOperator == '*')){
            throw new IllegalArgumentException("연산자 외 다른 값");
        }
    }

    /**
     * 사칙연산
     * @param Operator
     * @param a
     * @param b
     * @return
     */
    public static int commonCalculate(final char operator, final int first, final int second ){
        int returnValue = 0;

        switch(operator) {
            case '+':
                returnValue = CommonCalculate.addCalculate(first, second);
                break;
            case '-':
                returnValue = CommonCalculate.subCalculate(first, second);
                break;
            case '*':
                returnValue = CommonCalculate.mulCalculate(first, second);
                break;
            case '/':
                returnValue = CommonCalculate.divCalculate(first, second);
                break;
        }

        return returnValue;
    }



    /**
     * 단계를 나누어 계산
     */
    public static int stepToCalculatorRun(final String paramText, final List<OperatorOrder> list ){
        int returnValue = 0;

        for(int i=0; i<list.size(); i++){
            if(i == 0 ){
                if(list.size() > 1){
                    returnValue = RunCalculator.commonCalculate(list.get(i).getOperatorText()
                            , Integer.valueOf(paramText.substring(0, list.get(i).getIndex()))
                            , Integer.valueOf(paramText.substring(list.get(i).getIndex()+1, list.get(i+1).getIndex()))
                    );
                }else{
                    returnValue = RunCalculator.commonCalculate(list.get(i).getOperatorText()
                            , Integer.valueOf(paramText.substring(0, list.get(i).getIndex()))
                            , Integer.valueOf(paramText.substring(list.get(i).getIndex()+1, paramText.length()))
                    );
                }
            } else if(i < list.size() - 1){
                returnValue = RunCalculator.commonCalculate(list.get(i).getOperatorText()
                        , returnValue
                        , Integer.valueOf(paramText.substring(list.get(i).getIndex()+1, list.get(i+1).getIndex()))
                );
            }else {
                returnValue = RunCalculator.commonCalculate(list.get(i).getOperatorText()
                        , returnValue
                        , Integer.valueOf(paramText.substring(list.get(i).getIndex()+1, paramText.length()))
                );
            }
        }

        return returnValue;
    }

    /**
     * 문자열을 받아서 연산자의 index와 연산자를 return
     * @param param 문자열
     * @return list - 연잔자 및 index의 list
     */
    public static List<OperatorOrder>  operatorDivision (final String param){
        List<OperatorOrder> list = new ArrayList<OperatorOrder>();
        OperatorOrder operOrder = new OperatorOrder();
        char temp;

        for(int i=0; i < param.toCharArray().length; i++){
            temp = param.toCharArray()[i];
            if(!('0' <= temp && temp <= '9')){
                paramOperatorCheck(temp);
                operOrder = new OperatorOrder();
                operOrder.setIndex(i);
                operOrder.setOperatorText(temp);
                list.add(operOrder);
            }
        }

        return list;
    }



}
