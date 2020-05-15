package mission1.stringCalculator;

public class Calculator {
    private StrCalcCondition condition;
    private Operation operation;
    private double accumulatedCalcResult;

    public Calculator() {
        condition = new StrCalcCondition();
        operation = new Operation();
    }

    public double calculate(String strForCalc) {
        condition.checkCondition(strForCalc);

        String[] splitUp = strForCalc.split(" ");
        accumulatedCalcResult = Double.parseDouble(splitUp[0]);

        for (int i = 1; i < splitUp.length; i += 2) {
            accumulatedCalcResult = operation.operator(splitUp[i], accumulatedCalcResult, Double.parseDouble(splitUp[i + 1]));
        }

        return accumulatedCalcResult;
    }
}
