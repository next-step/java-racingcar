package calculator;

public class InternalCalculator {

    private static RequestInput requestInput = new RequestInput();

    public void startCalculator() throws IllegalArgumentException {
        String[] inputArray = requestInput.askUserForSuitableInput();
        CalculationInfo calculationInfo = requestInput
            .convertToCalculationInfo(inputArray, 0, Integer.parseInt(inputArray[0]));
        for (int i = 2; i < inputArray.length - 2; i += 2) {
            calculationInfo = requestInput
                .convertToCalculationInfo(inputArray, i, calculate(calculationInfo));
        }
        PrintUtils.printResultOutput(calculate(calculationInfo));
    }

    public int calculate(CalculationInfo calculationInfo) {
        Operator operator = calculationInfo.getOperator();
        int dividend = calculationInfo.getDividend();
        int divisor = calculationInfo.getDivisor();
        if (operator.equals(ADD)) {
            return CalculatorUtils.add(dividend, divisor);
        }
        if (operator.equals(SUBTRACT)) {
            return CalculatorUtils.subtract(dividend, divisor);
        }
        if (operator.equals(MULTIPLY)) {
            return CalculatorUtils.multiply(dividend, divisor);
        }
        if (operator.equals(DIVIDE)) {
            return CalculatorUtils.divide(dividend, divisor);
        }
        return 0;
    }
}
