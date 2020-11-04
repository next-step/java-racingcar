package stringCalculator;

import java.util.List;

public class Operate {

    private int result = 0;
    // 연산자의 개수(초기 값 1)
    // 연산자의 개수와 피연산자의 첫 자리만 빼면 개수는 같다.
    private int operatorCnt = 1;

    public Operate(List<Integer> operands, List<String> operators) {
        result = operands.get(0); // 첫 자리 값 셋팅;
        for (String operator : operators) {
            operate(operands, operator);
            operatorCnt++;
        }
    }

    private void operate(List<Integer> operands, String operator) {
        int operand = operands.get(operatorCnt);
        calculate(operand, operator);
    }

    private void calculate(int operand, String operator) {
        for (Calculate value : Calculate.values()) {
            if (operator.equals(value.getOperator())) {
                result = value.calculate(result, operand);
            }
        }
    }

    public int getResult() {
        return result;
    }
}
