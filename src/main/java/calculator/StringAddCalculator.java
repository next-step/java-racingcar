package calculator;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class StringAddCalculator {
    public int calculate(String input) {
        if (StringUtils.isBlank(input)) {
            return 0;
        }

        if (NumberUtils.isNumber(input)) {
            return Integer.parseInt(input);
        }

        String[] inputs = input.split(",|:");
        if (inputs.length == 2) {
            int firstNumber = Integer.parseInt(inputs[0]);
            int secondNumber = Integer.parseInt(inputs[1]);

            return firstNumber + secondNumber;
        }


        return 0;
    }
}
