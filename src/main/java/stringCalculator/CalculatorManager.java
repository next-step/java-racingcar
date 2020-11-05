package stringCalculator;

import java.util.List;

public class CalculatorManager {

    private int result = 0;

    public CalculatorManager(List<Integer> operands, List<String> operators) {
        result = operands.get(0); // 첫 자리 값 셋팅;
        int operatorCnt = 1;

        for (String operator : operators) {
            // 연산자의 개수(초기 값 1)
            // 연산자의 개수와 피연산자의 첫 자리만 빼면 개수는 같다.
            int operand = operands.get(operatorCnt);
            calculate(operand, operator);
            operatorCnt++;
        }
    }

    private void calculate(int operand, String operator) {
        for (Operator value : Operator.values()) {
            if (operator.equals(value.getOperator())) {
                result = value.calculate(result, operand);
            }
        }
    }

    public int getResult() {
        return result;
    }
}
