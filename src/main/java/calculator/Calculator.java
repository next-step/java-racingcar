package calculator;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * 문자열 계산기
 */
public class Calculator {
    private final String[] inputs;
    private final Queue<String> expressions = new LinkedList<>();

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

    /**
     * 순서대로 계산한다.
     */
    public Number calculate() {
        for (String input : inputs) {
            expressions.offer(input);
            preCalculate();
        }

        // todo 연산자(ex)"+")만 들어올 경우 처리해야 함
        if (expressions.size() == 1) {
            return Number.of(expressions.poll());
        }

        return makeExpression().orElseThrow(() -> new IllegalArgumentException("계산할 수 없습니다.")).calculate();
    }

    /**
     * 계산이 가능하면 먼저 계산해서 결과값을 반환한다.
     */
    private void preCalculate() {
        Optional<Expression> expression = makeExpression();
        if (!expression.isPresent()) {
            return;
        }
        expressions.offer(expression.get().calculate().toString());
    }

    /**
     * 수식을 만든다.
     */
    private Optional<Expression> makeExpression() {
        if (!isCalculate()) {
            return Optional.empty();
        }
        String num1 = expressions.poll();
        String op = expressions.poll();
        String num2 = expressions.poll();
        return Optional.of(Expression.create(Number.of(num1), op, Number.of(num2)));
    }

    private boolean isCalculate() {
        return expressions.size() == 3;
    }

}
