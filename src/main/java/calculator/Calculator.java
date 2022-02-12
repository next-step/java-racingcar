package calculator;

import java.util.List;

public class Calculator {

    public double calculateByOperator(List<String> userString) {
        double result = Double.parseDouble(userString.get(0));
        int userInputSize = userString.size();
        for (int i = 1; i < userInputSize - 1; i += 2) {
            String symbol = userString.get(i);
            double operand = Double.parseDouble(userString.get(i + 1));
            Operator operator = Operator.matchOperator(symbol);
            result = operator.apply(result, operand);
        }
        return result;
    }

}
