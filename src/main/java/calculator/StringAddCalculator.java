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

        InputValue inputValue = new InputValue(input);
        return inputValue.getResult();
    }
}
