package racingcar.step2;

import racingcar.step2.operation.Operation;
import racingcar.step2.operation.Operations;

import java.util.Stack;

public class StringCalculator {

    public String calculate(String[] input) {
        Stack<String> stack = CalculatorUtil.getStack(input);
        while (stack.size() != 1) {
            stackCalculate(stack);
        }
        return stack.get(0);
    }

    //들여쓰기 규칙 : 메서드 추출
    private void stackCalculate(Stack<String> stack) {
        String left = stack.pop();
        if (CalculatorUtil.list.contains(stack.peek())) {
            String sign = stack.pop();
            String right = stack.pop();
            // Operation, 객체 생성이 많을 것 같다....
            Operations operations = new Operations(left, right);
            Operation operation = operations.getOperation(sign);
            stack.push(operation.operate());
        }
    }

}
