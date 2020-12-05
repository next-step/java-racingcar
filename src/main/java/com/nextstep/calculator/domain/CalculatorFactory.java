package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.EmptyFormulaException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorFactory {
    private static final String FORMULA_SPLITTER = " ";

    public static Calculator createCalculator(final String formula) {
        validateEmpty(formula);

        List<String> formulaContents = Arrays.asList(formula.split(FORMULA_SPLITTER));

        return new Calculator(extractOperators(formulaContents), extractNumbers(formulaContents));
    }

    private static void validateEmpty(final String formula) {
        if ("".equals(formula.trim())) {
            throw new EmptyFormulaException("문자열 수식이 반드시 존재해야 합니다.");
        }
    }

    private static List<Number> extractNumbers(final List<String> formulaContents) {
        return formulaContents.stream()
                .filter(formulaContent -> !Operator.isOperator(formulaContent))
                .map(Number::of)
                .collect(Collectors.toList());
    }

    private static List<Operator> extractOperators(final List<String> formulaContents) {
        return formulaContents.stream()
                .filter(Operator::isOperator)
                .map(Operator::of)
                .collect(Collectors.toList());
    }
}
