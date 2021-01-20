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
        switch (operator) {
            case ADD:
                return CalculatorUtils.add(dividend, divisor);
            case SUBTRACT:
                return CalculatorUtils.subtract(dividend, divisor);
            case MULTIPLY:
                return CalculatorUtils.multiply(dividend, divisor);
            case DIVIDE:
                return CalculatorUtils.divide(dividend, divisor);
            default:
                throw new IllegalArgumentException();
        }
        return 0;
    }
}
