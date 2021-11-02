package racingcar_2step;

import racingcar_2step.operation.Operation;
import racingcar_2step.operation.Operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StringCalculator {
    private List<Operations> list = new ArrayList<>();

    public String calculate(String[] input) {
        Stack<String> stack = CalculatorUtil.getStack(input);
        while (stack.size() != 1) {
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
        return stack.get(0);
    }

}
