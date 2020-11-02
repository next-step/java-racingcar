package calculator;

import calculator.domain.Operator;

import java.util.List;

public class Calculator {

    public int calculate(String input) {
        CalculatorParser calculatorParser = new CalculatorParser();

        String[] expression = calculatorParser.parseExpression(input);
        int initialValue = calculatorParser.getInitialValue(expression);

        List<Operator> operators = calculatorParser.getOperatorList(expression);
        List<Integer> numbers = calculatorParser.getNumberListWithoutInitialNumber(expression);
        calculatorParser.validate(operators, numbers);

        return calculate(initialValue, operators, numbers);
    }

    private int calculate(int initialValue, List<Operator> operators, List<Integer> numbers) {
        int result = initialValue;

        for (int x = 0; x < numbers.size(); x++) {
            result = operators.get(x).apply(result, numbers.get(x));
        }

        return result;
    }
}
