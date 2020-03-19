package calculator;


import org.junit.platform.commons.util.StringUtils;

public class Calculator {

    private static final String Separator = " ";

    private CalculationOrder calculationOrder = new CalculationOrder();

    public long calculate(String input) {
        verifyInput(input);
        calculationOrder.init(input.split(Separator));
        long x = stringToNumber(calculationOrder.next());

        return 0;
    }

    private long stringToNumber(String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void verifyInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException();
        }
    }
}
