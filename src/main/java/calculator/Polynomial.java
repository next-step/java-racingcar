package calculator;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Polynomial {
    private List<String> operators;
    private List<Integer> operands;
    private Integer resultCache = null;

    private Polynomial(List<Integer> operands, List<String> operators) {
        this.operands = operands;
        this.operators = operators;
    }

    public static Polynomial createPolynomialWithExpression(String expression) {
        if (!PolynomialParser.isValid(expression)) {
            throw new IllegalArgumentException("수식이 올바르지 않습니다.");
        }

        List<Integer> operands = PolynomialParser.extractOperands(expression);
        List<String> operators = PolynomialParser.extractOperators(expression);

        return new Polynomial(operands, operators);
    }


    public int calculate() {
        if (resultCache != null) {
            return resultCache;
        }

        Stack<Integer> operands = convertListToStack(reverse(this.operands));
        Stack<String> operators = convertListToStack(reverse(this.operators));

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

    private <E> Stack<E> convertListToStack(List<E> list) {
        Stack<E> stack = new Stack<>();
        stack.addAll(list);

        return stack;
    }

    private <E> List<E> reverse(List<E> list) {
        return IntStream.range(0, list.size())
                .map(i -> (list.size() - 1 - i))
                .mapToObj(list::get)
                .collect(Collectors.toList());
    }
}

