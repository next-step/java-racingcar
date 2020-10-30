package calculator;


import java.util.ArrayList;
import java.util.List;

/**
 * 문자열 중에서 연산자가 존재하는 index와 해당되는 문자열 저장하는 객체
 */
public class OperatorOrder {

    private char operatorText; // 연산자
    private int index;  // 연산자가 존재하는 inex

    OperatorOrder(char operatorText, int index){
        this.operatorText = operatorText;
        this.index = index;
    }

    public char getOperatorText() {
        return operatorText;
    }
    public int getIndex() {
        return index;
    }

    /**
     * 문자열을 받아서 연산자의 index와 연산자를 return
     * @param param 문자열
     * @return list - 연잔자 및 index의 list
     */
    public static List<OperatorOrder> operatorDivision (final String param){
        List<OperatorOrder> list = new ArrayList<OperatorOrder>();
        char temp;

        for (int i = 0; i < param.toCharArray().length; i++){
            paramNumberCheckAndListAdd(param.toCharArray()[i], i, list);
        }

        return list;
    }

    /**
     * char형의 문자를 숫자인지 영문인지 확인 후 list에 index와 함께 담기
     * @param paramNumber 숫자인지 영문인지
     * @param index 문자열에서 연산자 index
     * @param list
     */
    private static void paramNumberCheckAndListAdd(char paramNumber, int index, List<OperatorOrder> list){
        if (!('0' <= paramNumber && paramNumber <= '9')){
            paramOperatorCheck(paramNumber);
            list.add(new OperatorOrder(paramNumber, index));
        }
    }

    /**
     * 연산자 체크
     * @param Operator
     * @return
     */
    private static void paramOperatorCheck(final char paramOperator){
        if (!(paramOperator == '+' || paramOperator == '-' || paramOperator == '/' || paramOperator == '*')){
            throw new IllegalArgumentException("연산자 외 다른 값");
        }
    }
}
