package com.kkambi.racing.util;

import java.util.*;
import java.util.function.BiFunction;

/**
 * 사칙 연산이 들어간 문자열 식을 계산하는 유틸리티 클래스.
 * 수학적으로 정해진 연산자 우선순위가 아닌, 입력한 순서를 그대로 따라 계산하므로 주의할 것.
 *
 * @author  KKambi
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

    /**
     * 사칙 연산 문자열에서 숫자와 연산자를 분리하고 계산하기 위한 클래스.
     * 숫자의 타입 체크를 위해 {@link TypeChecker#isInteger(String)} 메소드를 사용한다.
     *
     * @see TypeChecker
     */
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
