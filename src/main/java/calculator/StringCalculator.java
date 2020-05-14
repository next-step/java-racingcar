package calculator;

import calculator.utils.SplitUtils;
import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    public static int calculate(String input) {

        checkInputValue(input);

        StringCalculatorEntity entity = new StringCalculatorEntity(SplitUtils.split(input, " "));

        int result = entity.getOperandItem(0); //첫번째 피연산자로 시작
        int operatorIndex = 0; //연산자 시작 index
        int secondOperandIndex = 1; //두번째 피연산자 index

        do {
            //result에 앞의 연산 결과를 대입하며 반복문으로 연산식을 줄여가며 결과를 구합니다.
            //ex) (result = 3)     3 + 3 / 2 * 2
            //    (result = 3 + 3) 6 / 2 * 2
            //    (result = 6 / 2) 3 * 2
            //    (result = 3 * 2) 6
            result = doFourOperate(entity.getOperatorItem(operatorIndex++),
                                        result,
                                        entity.getOperandItem(secondOperandIndex++));

            //validation이 끝났기 때문에 연산자의 위치만으로 loop 조건을 지정할 수 있습니다.
        } while (operatorIndex < entity.getOperatorCount());


        return result;
    }

    /**
     * 4칙연산 메소드
     * @param operator 연산자
     * @param firstOperand 첫번째 피연산자
     * @param secondOperand 두번째 피연산자
     * @return 연산 결과
     */
    private static int doFourOperate(String operator, int firstOperand, int secondOperand) {

        if ("+".equals(operator)) {
            return firstOperand + secondOperand;
        }

        if ("-".equals(operator)) {
            return firstOperand - secondOperand;
        }

        if ("*".equals(operator)) {
            return firstOperand * secondOperand;
        }

        if ("/".equals(operator)) {
            return firstOperand / secondOperand;
        }

        //이미 validation 해주었기 때문에 return 0;이 될리가 없음..
        return 0;
    }

    /**
     * input 이 빈값인지와 수식의 길이만 체크한다.
     * @param input 입력한 수식
     */
    private static void checkInputValue(String input) {
        if (StringUtils.isBlank(input) || input.length() < 5) {
            throw new IllegalArgumentException("잘못된 수식입니다 : " + input);
        }
    }


}
