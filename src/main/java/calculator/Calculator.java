package calculator;

import java.util.*;
import java.util.stream.Collectors;

public class Calculator {

    public double calculateMathExpression(String mathExpression) {
        String removeBlankMathExpression = mathExpression.replaceAll(" ", "");

        List<String> operators = getOperators(removeBlankMathExpression);
        Queue<String> operatorsQueue = new LinkedList<>(operators);

        List<Double> numbers = getNumbers(removeBlankMathExpression);
        Stack<Double> numbersStack = makeNumbersStack(numbers);

        return calculateAll(operatorsQueue, numbersStack);
    }

    public double calculate(String operator, Double numberA, Double numberB) {
        switch (operator) {
            case "+":
                return numberA + numberB;
            case "-":
                return numberA - numberB;
            case "*":
                return numberA * numberB;
            case "/":
                return (double) numberA / numberB;
            default:
                throw new IllegalArgumentException("잘못된 연산 기호");
        }
    }

    private double calculateAll(Queue<String> operatorsQueue, Stack<Double> numbersStack) {
        while (!operatorsQueue.isEmpty()) {
            numbersStack.push(calculate(operatorsQueue.poll(), numbersStack.pop(), numbersStack.pop()));
        }
        return numbersStack.pop();
    }

    private List<String> getOperators(String removeBlankMathExpression) {
        return removeBlankMathExpression.replaceAll("[(\\w)]", "").chars()
                .mapToObj(c -> String.valueOf((char) c)).collect(Collectors.toList());
    }

    private List<Double> getNumbers(String removeBlankMathExpression) {
        String[] split = removeBlankMathExpression.split("[(+|-|*|/)]");
        return Arrays.stream(split).map(Double::parseDouble).collect(Collectors.toList());
    }

    private Stack<Double> makeNumbersStack(List<Double> numbers) {
        Stack<Double> stack = new Stack<>();
        for (int i = numbers.size(); i > 0; i--) {
            stack.push(numbers.get(i - 1));
        }
        return stack;
    }

}
