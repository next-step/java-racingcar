package calculator;

import calculator.util.CollectionUtils;

import java.util.List;
import java.util.Stack;

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

        List<Integer> reversedOperands = CollectionUtils.reverse(this.operands);
        List<String> reversedOperators = CollectionUtils.reverse(this.operators);

        Stack<Integer> operands = CollectionUtils.convertListToStack(reversedOperands);
        Stack<String> operators = CollectionUtils.convertListToStack(reversedOperators);

        while (!operators.isEmpty()) {
            resultCache = performBinaryOperation(operands, operators);
        }

        return resultCache;
    }

    private int performBinaryOperation(Stack<Integer> operands, Stack<String> operators) {
        int operand1 = operands.pop();
        int operand2 = operands.pop();
        String operator = operators.pop();

        Operable operable = BinaryOperator.of(operator);
        int result = operable.calculate(operand1, operand2);

        operands.add(result);
        return result;
    }
}

