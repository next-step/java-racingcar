package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Collectors;

public class StringCalculatorTest {

    @DisplayName("계산식 정상 수행 테스트")
    @ParameterizedTest(name = "{displayName} [{index}]: ''{argumentsWithNames}''")
    @CsvSource( {"'2 + 3 * 4 / 2', 10.0"})
    void calculateMathExpression(String mathExpression, double expectedNumber) {
        double result = calculateMathExpression(mathExpression);
        Assertions.assertThat(result).isEqualTo(expectedNumber);
    }

    @DisplayName("공백 계산식 예외 발생 테스트")
    @ParameterizedTest(name = "{displayName} [{index}]: ''{argumentsWithNames}''")
    @ValueSource(strings = {" ", ""})
    void calculateBlankExcept(String mathExpression) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculateMathExpression(mathExpression))
                .withMessageMatching("empty String");
    }

    @DisplayName("연산자 테스트")
    @ParameterizedTest(name = "{displayName} [{index}]: ''{argumentsWithNames}''")
    @CsvSource({    "'+',2,3,5",
                    "'-',5,2,3",
                    "'/',6,2,3",
                    "'*',5,2,10"})
    void operatorTest(String operator, double numberA, double numberB, double expectedResult) {
        Assertions.assertThat(this.calculate(operator, numberA, numberB)).isEqualTo(expectedResult);
    }


    private double calculateMathExpression(String mathExpression) {
        String removeBlankMathExpression = mathExpression.replaceAll(" ", "");

        List<String> operators = getOperators(removeBlankMathExpression);
        Queue<String> operatorsQueue = new LinkedList<>(operators);

        List<Double> numbers = getNumbers(removeBlankMathExpression);
        Stack<Double> numbersStack = makeNumbersStack(numbers);

        return calculateAll(operatorsQueue, numbersStack);
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
