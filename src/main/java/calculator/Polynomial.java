package calculator;

import java.util.*;

class Polynomial {
    private List<String> operators;
    private List<Integer> operands;
    private Integer resultCache = null;

    private Polynomial(List<Integer> operands, List<String> operators) {
        this.operands = operands;
        this.operators = operators;
    }

    static Polynomial createPolynomialWithExpression(String expression) {
        if (!PolynomialParser.isValid(expression)) {
            throw new IllegalArgumentException("입력 수식이 수식 표현 규약에 어긋납니다.");
        }

        List<Integer> operands = PolynomialParser.extractOperands(expression);
        List<String> operators = PolynomialParser.extractOperators(expression);

        return new Polynomial(operands, operators);
    }

    int calculate() {
        if (resultCache != null) {
            return resultCache;
        }

        Deque<Integer> operands = new LinkedList<>(this.operands);
        Queue<String> operators = new LinkedList<>(this.operators);

        while (!operators.isEmpty()) {
            resultCache = performBinaryOperation(operands, operators);
        }

        return resultCache;
    }

    private int performBinaryOperation(Deque<Integer> operands, Queue<String> operators) {
        int operand1 = operands.pollFirst();
        int operand2 = operands.pollFirst();
        String operator = operators.poll();

        Operable operable = BinaryOperator.of(operator);
        int result = operable.calculate(operand1, operand2);

        operands.offerFirst(result);
        return result;
    }
}

