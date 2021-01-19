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
    }

    /*
    public int startCalculator() {
        String[] inputArray = requestInput.askUserForSuitableInput();
        //TODO : 받아온 문자열을 연산하는 클래스함수 호출?
        return getTotal();
    }*/

    private int getTotal(ArrayList<CalculationInfo> calculationUserInfo) {
        int total = 0;
        for (int i = 0; i < calculationUserInfo.size(); i++) {
            total += calculate(calculationUserInfo.get(i));
        }
        return total;
    }

    private int calculate(CalculationInfo calculationInfo) {
        Operator operator = calculationInfo.getOperator();
        int dividend = calculationInfo.getDividend();
        int divisor = calculationInfo.getDivisor();
        switch (operator) {
            case ADD:
                return dividend + divisor;
            case SUBTRACT:
                return dividend - divisor;
            case MULTIPLY:
                return dividend * divisor;
            default:
                return dividend / divisor;
        }
    }
}
