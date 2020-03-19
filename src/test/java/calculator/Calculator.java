package calculator;


import org.junit.platform.commons.util.StringUtils;

public class Calculator {

    private static final String Separator = " ";

    private CalculationOrder calculationOrder = new CalculationOrder();

    public long calculate(String input) {
        verifyInput(input);
        calculationOrder.init(input.split(Separator));
        return 0;
    }

    private void verifyInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException();
        }
    }
}
