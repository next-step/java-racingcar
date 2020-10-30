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

    public int calculate(Expression expression) {

        List<String> expressions = expression.getSplittedStrings(" ");

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

        return operators.stream()
                .filter(operator -> operator.isOperator(operatorExp))
                .findFirst()
                .orElseThrow(() -> {
                    String message = String.format("연산자 Expression이 아닙니다. (operatorExp = %s)", operatorExp);
                    return new IllegalArgumentException(message);
                });
    }

    class SingleCalculation {

        Operand firstArg;
        Operand secondArg;
        Operator operator;

        public SingleCalculation(List<String> expressions) {

            validate(expressions);

            this.firstArg = toOperand(expressions.get(0));
            this.operator = findOperator(expressions.get(1));
            this.secondArg = toOperand(expressions.get(2));
        }

        private void validate(List<String> expressions) {
            if (expressions.size() < 3) {
                throw new IllegalArgumentException("연산에 필요한 Expression이 부족합니다.");
            }
        }

        public Integer getResult() {
            return operator.operate(firstArg, secondArg);
        }

    }
}
