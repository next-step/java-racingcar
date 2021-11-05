package com.kkambi.racing.util;

import java.util.*;
import java.util.function.BiFunction;

/*

4. 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.


- 사칙연산 기호가 아닌 경우 IllegalArgumentException throw

 */
public class StringCalculator {

    private static final String DELIMITER = " ";

    private StringCalculator() {
        throw new AssertionError();
    }

    public static int calculate(String formula) {
        CalculationStack calculationStack = new CalculationStack();

        if (Objects.isNull(formula) || formula.isEmpty() || formula.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }

        insertElement(calculationStack, formula);
        return calculateUsingStack(calculationStack);
    }

    private static void insertElement(CalculationStack calculationStack, String formula) {
        String[] splitFormula = formula.split(DELIMITER);

        for (int index = splitFormula.length - 1; index >= 0; index--) {
            calculationStack.insertElement(splitFormula[index]);
        }
    }

    private static int calculateUsingStack(CalculationStack calculationStack) {
        int finalResult = 0;
        while (!calculationStack.isEmpty()) {
            int result = calculationStack.calculate();
            calculationStack.push(result);
            finalResult = result;
        }

        return finalResult;
    }

    private static class CalculationStack {

        private final Stack<Integer> numberStack = new Stack<>();
        private final Stack<Operator> operatorStack = new Stack<>();

        private void insertElement(String element) {
            if (TypeChecker.isInteger(element)) {
                numberStack.push(Integer.valueOf(element));
                return;
            }

            operatorStack.push(Operator.fromString(element));
        }

        private boolean isEmpty() {
            return operatorStack.isEmpty();
        }

        private int calculate() {
            int number1 = numberStack.pop();
            int number2 = numberStack.pop();
            Operator operator = operatorStack.pop();
            return operator.calculate(number1, number2);
        }

        private void push(int value) {
            numberStack.push(value);
        }
    }

    private enum Operator {
        PLUS("+", (x, y) -> x + y),
        MINUS("-", (x, y) -> x - y),
        MULTIPLY("*", (x, y) -> x * y),
        DIVIDE("/", (x, y) -> x / y);

        private static final Map<String, Operator> SYMBOL_TO_OPERATOR = new HashMap<>();
        private final String symbol;
        private final BiFunction<Integer, Integer, Integer> calculation;

        static {
            for (Operator operator : Operator.values()) {
                SYMBOL_TO_OPERATOR.put(operator.symbol, operator);
            }
        }

        Operator(String symbol, BiFunction<Integer, Integer, Integer> calculation) {
            this.symbol = symbol;
            this.calculation = calculation;
        }

        private static Operator fromString(String symbol) {
            Operator operator = SYMBOL_TO_OPERATOR.get(symbol);

            if (Objects.isNull(operator)) {
                throw new IllegalArgumentException("올바른 사칙연산 기호가 아닙니다.");
            }

            return operator;
        }

        private int calculate(int x, int y) {
            return calculation.apply(x, y);
        }
    }
}
