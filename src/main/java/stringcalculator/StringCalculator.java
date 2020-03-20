package stringcalculator;

import static stringcalculator.Operation.*;

public class StringCalculator {

    public double operate(String expression) {
        double acc = 0;
        Operation operator = PLUS;

        String[] values = expression.split(" ");

        for (String s : values) {
            if (Operation.isOperator(s)) {
                operator = Operation.of(s);
                continue;
            }
            acc = operator.apply(acc, Double.parseDouble(s));
        }

        return acc;
    }
}
