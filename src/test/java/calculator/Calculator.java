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
        while (calculationOrder.isCalculate()) {
            BinomialExpression binomialExpression = calculationOrder.nextBinomialExpression();
            calculationOrder.addCalculateResult(binomialExpression.calculate());
        }
        return calculationOrder.getCurrentNumber();
    }

    private void verifyInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException();
        }
    }
}
