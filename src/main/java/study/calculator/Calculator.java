package study.calculator;

import study.calculator.operator.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Calculator {

    List<Operator> operators = new ArrayList<>();

    public Calculator() {
        this.operators.add(new Plus());
        this.operators.add(new Minus());
        this.operators.add(new Multiply());
        this.operators.add(new Division());
    }

    public int calculate(String expression) {

        if (Objects.isNull(expression) || expression.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        List<String> expressions = Arrays.asList(expression.split(" "));

        while (expressions.size() > 1) {
            SingleCalculation singleCalculation = new SingleCalculation(expressions);
            expressions = nextExpressions(expressions, singleCalculation.getResult());
        }

        return Integer.parseInt(expressions.get(0));
    }

    private List<String> nextExpressions(List<String> expressions, Integer result) {
        List<String> resultExpressions = new ArrayList<>();
        resultExpressions.add(result.toString());
        for (String expression : expressions.subList(3, expressions.size())) {
            resultExpressions.add(expression);
        }
        return resultExpressions;
    }

    private Operand toOperand(String integerExp) {
        return new Operand(Integer.parseInt(integerExp));
    }

    private Operator findOperator(String operatorExp) {
        for (Operator operator : operators) {
            if (operator.isOperator(operatorExp)) {
                return operator;
            }
        }
        throw new IllegalArgumentException();
    }

    class SingleCalculation {

        Operand firstArg;
        Operand secondArg;
        Operator operator;

        public SingleCalculation(List<String> expressions) {
            if (expressions.size() < 3) {
                throw new IllegalArgumentException();
            }
            this.firstArg = toOperand(expressions.get(0));
            this.operator = findOperator(expressions.get(1));
            this.secondArg = toOperand(expressions.get(2));
        }

        public boolean isReadyForCalculate() {
            return Objects.nonNull(firstArg)
                    && Objects.nonNull(secondArg)
                    && Objects.nonNull(operator);
        }

        public Integer getResult() {
            return operator.operate(firstArg, secondArg);
        }


    }
}
