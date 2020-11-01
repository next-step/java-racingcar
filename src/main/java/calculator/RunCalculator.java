package calculator;

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
        List<OperatorOrder> list = OperatorOrder.operatorDivision(refineText);

        return runStepToCalculator(refineText, list);
    }

    /**
     * 계산에 사용될 Text를 Check
     * @param paramText
     * @return 정제된 문자열.
     */
    private static void paramTextCheck(final String paramText){
        isNullOrEmptyCheck(paramText);
        isBlankCheck(paramText);
    }

    /**
     * null과 empty 체크
     * @param paramText
     */
    private static void isNullOrEmptyCheck(String paramText) {
        if (paramText == null || paramText.length() == 0) {
            throw new IllegalArgumentException("연산할 Text가 null");
        }
    }

    /**
     * 공백 체크
     * @param paramText
     */
    private static void isBlankCheck(String paramText) {
        if (paramText.trim().length() == 0) {
            throw new IllegalArgumentException("연살한 Text가 empry");
        }
    }

    /**
     * 나누는값이 0인지 체크
     * @param paramNumber
     * @return
     */
    private static int isZeroCheck(final int paramNumber){
        if (paramNumber == 0){
            throw new ArithmeticException("값을 0으로 나눔");
        }

        return paramNumber;
    }

    /**
     * 문자열을 받아 계산 시작
     */
    public static int runStepToCalculator(final String paramText, final List<OperatorOrder> list ){
        int returnValue = 0;

        if (list.size() == 0){
            return Integer.valueOf(paramText);
        }

        for (int i = 0; i < list.size(); i++) {
            returnValue = runNumberSentence(new CalculatorParamValue(paramText, i, returnValue, list));
        }

        return returnValue;
    }

    /**
     * 사칙연산 시작 <br/>
     * lsit에 담겨있는 index에 따라 계산 방법 다르게
     * @param param
     * @return
     */
    private static int runNumberSentence(CalculatorParamValue param){
        //index가 0일대
        if (param.getListindex() == 0){
            return isIndexEqualsZero(param);
        }
        //index가 0이 아닐때
        return isIndexEqualsNotZero(param);
    }

    private static int isIndexEqualsZero(CalculatorParamValue param){
        String paramText = param.getParamText();
        int index = param.getListindex();
        List<OperatorOrder> list = param.getList();

        if (list.size() > 1){
            return CommonCalculate.commonCalculate(
                    new CalculatorParamValue( list.get(index).getOperatorText()
                        , Integer.valueOf(paramText.substring(0, list.get(index).getIndex()))
                        , Integer.valueOf(paramText.substring(list.get(index).getIndex()+1, list.get(index+1).getIndex()))
                    )
            );
        }

        return CommonCalculate.commonCalculate(
                new CalculatorParamValue(list.get(index).getOperatorText()
                , Integer.valueOf(paramText.substring(0, list.get(index).getIndex()))
                , Integer.valueOf(paramText.substring(list.get(index).getIndex()+1, paramText.length()))
                )
        );
    }

    private static int isIndexEqualsNotZero(CalculatorParamValue param) {
        String paramText = param.getParamText();
        int index = param.getListindex();
        List<OperatorOrder> list = param.getList();
        int returnValue = param.getReturnValue();

        if(index < list.size() - 1){
           return CommonCalculate.commonCalculate(
                   new CalculatorParamValue(list.get(index).getOperatorText()
                    , returnValue
                    , isZeroCheck(Integer.valueOf(paramText.substring(list.get(index).getIndex()+1, list.get(index+1).getIndex())))
                   )
            );
        }

        return CommonCalculate.commonCalculate(
                new CalculatorParamValue(list.get(index).getOperatorText()
                , returnValue
                , isZeroCheck(Integer.valueOf(paramText.substring(list.get(index).getIndex()+1, paramText.length())))
                )
        );
    }
}
