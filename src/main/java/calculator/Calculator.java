package calculator;

import calculator.domain.Operator;

import java.util.List;

public class Calculator {

    public int calculate(String input) {
        String[] expression = CalculatorParser.parseExpression(input);
        int initialValue = CalculatorParser.getInitialValue(expression);

        List<Operator> operators = CalculatorParser.getOperatorList(expression);
        List<Integer> numbers = CalculatorParser.getNumberListWithoutInitialNumber(expression);
        CalculatorParser.validate(operators, numbers);

        return calculate(initialValue, operators, numbers);
    }

    private int calculate(int initialValue, List<Operator> operators, List<Integer> numbers) {
        int result = initialValue;

        for (int x = 0; x < numbers.size(); x++) {
            result = operators.get(x).calculate(result, numbers.get(x));
        }

        return result;
    }
}
