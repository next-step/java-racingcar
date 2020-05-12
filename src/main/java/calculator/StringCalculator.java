package calculator;

import calculator.exception.EmptyInputException;
import calculator.operator.FourArithmeticOperator;
import calculator.util.SplitWhitespace;
import org.apache.commons.lang3.StringUtils;

public class StringCalculator {
    public int calculate(String input) {
        if (StringUtils.isBlank(input)) {
            throw new EmptyInputException();
        }

        String[] values = SplitWhitespace.split(input);

        int total = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length; i += 2) {
            String operation = values[i];
            int target = Integer.parseInt(values[i + 1]);

            total = FourArithmeticOperator.operate(total, target, operation);
        }

        return total;
    }
}
