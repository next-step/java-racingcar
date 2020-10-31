package stringCalculator;

import java.util.List;

/**
 * 연산하는 클래스
 */
public class Operate {

    private int result = 0;
    // 연산자의 개수(초기 값 1)
    // 연산자의 개수와 피연산자의 첫 자리만 빼면 개수는 같다.
    private int operatorCnt = 1;

    public Operate(List<Integer> operands, List<String> operators) {
        result = operands.get(0); // 첫 자리 값 셋팅;
        // 연산자 루프
        for (String operator : operators) {
            operate(operands, operator);
            operatorCnt++;
        }
    }

    /**
     * 피연산자 가공
     */
    private void operate(List<Integer> operands, String operator) {
        int operand = operands.get(operatorCnt);
        operate(operand, operator);
    }

    /**
     * 사칙연산 수행
     */
    private void operate(int operand, String operator) {
        if ("+".equals(operator)) {
            result += operand;
        } else if ("-".equals(operator)) {
            result -= operand;
        } else if ("*".equals(operator)) {
            result *= operand;
        } else if ("/".equals(operator)) {
            result /= operand;
        }
    }

    public int getResult() {
        return result;
    }
}
