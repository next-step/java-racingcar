package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    private String[] inputs;
    private Queue<String> expressions = new LinkedList<>();

    public Calculator(String input) {
        validate(input);
        this.inputs = input.split(" ");
    }

    private void validate(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    private boolean isEmpty(String input) {
        return input == null || input.length() == 0;
    }

    public int calculate() {
        int result = 0;
        // 값을 큐에 넣으면서 계산
        for (int i = 0; i < inputs.length; i++) {
            expressions.offer(inputs[i]);
            if (expressions.size() == 3) {
                String num1 = expressions.poll();
                String op = expressions.poll();
                String num2 = expressions.poll();
                expressions.offer(calculate(op, num1, num2));
            }
        }

        // 마지막 계산
        while (!expressions.isEmpty() && expressions.size() == 3) {
            String num1 = expressions.poll();
            String op = expressions.poll();
            String num2 = expressions.poll();
            result = Integer.parseInt(calculate(op, num1, num2));
        }
        return (result == 0) ? Integer.parseInt(expressions.poll()) : result;
    }

    private String calculate(String operator, String operand1, String operand2) {
        return String.valueOf(Operator.calculate(operator, Integer.parseInt(operand1), Integer.parseInt(operand2)));
    }

}
