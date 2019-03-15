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
        if (inputs.length < 2) {
            throw new RuntimeException();
        }

        return addInputs(inputs);
    }

    private int addInputs(String[] inputs) {
        int result = 0;

        for (int i = 0; i < inputs.length; i++) {
            result += Integer.parseInt(inputs[i]);
        }

        return result;
    }
}
