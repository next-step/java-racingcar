package calculator;


import calculator.view.Input;
import calculator.view.Output;
import racing.utils.ExpressionPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public void execute() {
        String input = setMathExpression();
        List<String> strings = sliceMathExpression(input);
        Output.printResult(makeResult(strings));
    }

    private String setMathExpression() {
        Output.startMessageOutput();
        String mathExpression = Input.mathExpressionInput();

        if (mathExpression.trim().isEmpty()) {
            throw new IllegalArgumentException("값을 입력해 주세요.");
        }
        if (ExpressionPattern.isExpression(mathExpression)) {
            throw new IllegalArgumentException("올바른 값을 입력해주세요.");
        }
        return mathExpression;
    }

    private List<String> sliceMathExpression(String mathExpression) {
        return Arrays.asList(mathExpression.split(" "));
    }

    private double makeResult(List<String> mathExpressionList) {
        double result = Double.parseDouble(mathExpressionList.get(0));
        int listSize = mathExpressionList.size();
        for (int i = 1; i < listSize; i += 2) {
            String operator = mathExpressionList.get(i);
            double number = Double.parseDouble(mathExpressionList.get(i + 1));
            result = calculate(number, operator, result);
        }
        return result;
    }

    private double calculate(double number, String operator, double result) {
        NumberCalculator numberCalculator = new NumberCalculator();

        if (operator.equals("+")) {
            return numberCalculator.add(result, number);
        }
        if (operator.equals("-")) {
            return numberCalculator.subtract(result, number);
        }
        if (operator.equals("*")) {
            return numberCalculator.multiply(result, number);
        }
        if (operator.equals("/")) {
            return numberCalculator.divide(result, number);
        }
        throw new IllegalArgumentException("올바른 연산자가 아닙니다.");
    }
}