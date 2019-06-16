package calculator;

import calculator.util.PolynomialParsingUtils;

import java.util.*;

class Polynomial {
    private List<Integer> operands;
    private List<Operable> operators;
    private Integer resultCache = null;

    private Polynomial(List<Integer> operands, List<Operable> operators) {
        this.operands = operands;
        this.operators = operators;
    }

    static Polynomial createPolynomialWithExpression(String expression) {
        PolynomialParsingUtils.isEmpty(expression);
        String[] terms = PolynomialParsingUtils.splitExpression(expression);

        return createPolynomialWithTerms(terms);
    }

    private static Polynomial createPolynomialWithTerms(String[] terms) {
        List<Integer> operands = new ArrayList<>();
        List<Operable> operators = new ArrayList<>();

        int firstOperand = PolynomialParsingUtils.convertToNumber(terms[0]);
        operands.add(firstOperand);

        for (int i = 1; i < terms.length; i += 2) {
            Operable operator = BinaryOperator.of(terms[i]);
            int operand = PolynomialParsingUtils.convertToNumber(terms[i + 1]);

            operands.add(operand);
            operators.add(operator);
        }

        return new Polynomial(operands, operators);
    }

    int calculate() {
        if (resultCache != null) {
            return resultCache;
        }

        Queue<Integer> operands = new LinkedList<>(this.operands);
        Queue<Operable> operators = new LinkedList<>(this.operators);

        resultCache = operands.poll();
        while (!operators.isEmpty()) {
            int operand = operands.poll();
            Operable operator = operators.poll();
            resultCache = operator.calculate(resultCache, operand);
        }

        return resultCache;
    }
}

