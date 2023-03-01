package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;
import java.util.stream.Collectors;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource( {"'2 + 3 * 4 / 2', 10.0"})
    void calculateClient(String mathExpression, double expectedNumber) {

        String removeBlankMathExpression = mathExpression.replaceAll(" ", "");

        List<String> operators = getOperators(removeBlankMathExpression);
        Queue<String> operatorsQueue = new LinkedList<>(operators);

        List<Double> numbers = getNumbers(removeBlankMathExpression);
        Stack<Double> numbersStack = makeNumbersStack(numbers);

        double result = calculateAll(operatorsQueue, numbersStack);

        Assertions.assertThat(result).isEqualTo(expectedNumber);

    }

    private double calculateAll(Queue<String> operatorsQueue, Stack<Double> numbersStack) {
        while (!operatorsQueue.isEmpty()) {
            numbersStack.push(calculate(operatorsQueue.poll(), numbersStack.pop(), numbersStack.pop()));
        }
        return numbersStack.pop();
    }

    private Stack<Double> makeNumbersStack(List<Double> numbers) {
        Stack<Double> stack = new Stack<>();
        for (int i = numbers.size(); i > 0; i--) {
            stack.push(numbers.get(i - 1));
        }
        return stack;
    }

    private List<Double> getNumbers(String removeBlankMathExpression) {
        String[] split = removeBlankMathExpression.split("[(+|-|*|/)]");
        return Arrays.stream(split).map(Double::parseDouble).collect(Collectors.toList());
    }

    private List<String> getOperators(String removeBlankMathExpression) {
        return removeBlankMathExpression.replaceAll("[(\\w)]", "").chars()
                .mapToObj(c -> String.valueOf((char) c)).collect(Collectors.toList());
    }

    double calculate(String operator, Double numberA, Double numberB) {
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
}
