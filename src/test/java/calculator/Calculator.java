package calculator;


import org.junit.platform.commons.util.StringUtils;

public class Calculator {

    private static final String SEPARATOR = " ";

    private CalculationOrder calculationOrder = new CalculationOrder();

    public long calculate(String input) {
        verifyInput(input);
        calculationOrder.init(input.split(SEPARATOR));
        return calculate();
    }

    private long calculate() {
        while (!calculationOrder.isComplete()) {
            long x = parseLong(calculationOrder.next());
            Operator operator = Operator.findOperatorByValue(calculationOrder.next());
            long y = parseLong(calculationOrder.next());
            calculationOrder.addCalculateResult(operator.calculate(x, y));
        }
        return calculationOrder.getCalculateTotalResult();
    }

    private long parseLong(String value) {
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
