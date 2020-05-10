package calculator;

import calculator.constants.Operator;

import java.util.List;

public class StringCalculator implements Calculator {

    @Override
    public double calculate(String input) {
        List<String> arguments = Argument.stringExpressionToList(input);

        double result = Double.valueOf(arguments.get(0));

        for (int i = 1; i < arguments.size(); i += 2) {
            Operator operator = Operator.getOperator(arguments.get(i));
            double secondValue = Double.valueOf(arguments.get(i+1));

            result = operator.apply(result, secondValue);
        }
       return result;
    }
}
