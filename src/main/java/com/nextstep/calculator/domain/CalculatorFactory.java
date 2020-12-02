package com.nextstep.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorFactory {
    private static final String FORMULA_SPLITTER = " ";

    public static Calculator of(String formula) {
        List<String> formulaContents = Arrays.asList(formula.split(FORMULA_SPLITTER));

        return new Calculator(extractOperators(formulaContents), extractNumbers(formulaContents));
    }

    private static List<Number> extractNumbers(List<String> formulaContents) {
        return formulaContents.stream()
                .filter(formulaContent -> !Operator.isOperator(formulaContent))
                .map(Number::of)
                .collect(Collectors.toList());
    }

    private static List<Operator> extractOperators(List<String> formulaContents) {
        return formulaContents.stream()
                .filter(Operator::isOperator)
                .map(Operator::of)
                .collect(Collectors.toList());
    }
}
