package calculator;

import util.StringUtils;

/**
 * Created by kohyusik on 25/10/2019.
 */
public class Calculator {

    private static final String DELIMITER = " ";

    public static int calculate(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("Input is required.");
        }

        String[] tokens = input.split(DELIMITER);
        int result = Integer.parseInt(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            Operator operator = Operator.of(tokens[i]);
            int operand = Integer.parseInt(tokens[i + 1]);
            result = operator.operate(result, operand);
        }

        return result;
    }
}