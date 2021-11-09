package com.rick.calculator;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Calculator {
    private static final String DELIMITER = " ";
    private static final Map<String, Operator> operatorMap = Arrays.stream(Operator.values()).collect(Collectors.toMap(Operator::getSymbol, Function.identity()));

    public static int calc(String formula) {
        validateFormula(formula);

        LinkedList<String> operandList = Arrays.stream(formula.split(DELIMITER)).collect(Collectors.toCollection(LinkedList::new));

        while (operandList.size() > 1) {
            int leftOperand = Integer.parseInt(operandList.pollFirst());
            String operatorSymbol = operandList.pollFirst();
            int rightOperand = Integer.parseInt(operandList.pollFirst());

            validateFormula(operatorSymbol);

            Operator operator = operatorMap.get(operatorSymbol);
            operandList.addFirst(Integer.toString(operator.calc(leftOperand, rightOperand)));
        }

        return Integer.parseInt(operandList.pollFirst());
    }

    public static void validateOperator(String operatorSymbol) {
        if (!operatorMap.containsKey(operatorSymbol)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateFormula(String formula) {
        if (Objects.isNull(formula) || formula.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
