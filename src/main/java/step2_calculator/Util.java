package step2_calculator;

public class Util {

    public static void checkEmpty(String input){
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException("input 값은 비어있을 수 없습니다.");
        }
    }

    public static Operator checkOperate(String checkOperate){
        return Operator.validate(checkOperate);
    }

    /*
     * String type의 피연산자를 받아 int 형태로 반환한다.
     * @Param operand 피연산자 문자; 숫자 범위 이내여야한다.
     * @return int 타입으로 변환한 형태
     * @throws IllegalArgumentException 숫자가 아닌 문자열을 받을시 발생한다.
     *  */
    public static int checkOperand(String operand){
        if(!operand.matches("^[0-9]+$"))
            throw new IllegalArgumentException("피연산자가 잘못되었습니다.");
        return Integer.parseInt(operand);
    }
}
