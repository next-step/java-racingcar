package calculator;

public class Calculator {

    public static int calculate(String input) {
        CalculationResult result = new CalculationResult(input);
        CalculatorFormula formula = new CalculatorFormula(input);
        for (int i = 1; i <= getLoopCount(input) / 2; i++) {
            int calculatedValue = Operator.getOperator(formula.getOperator(i))
                                          .calculate(result.getResult(), formula.getNumber(i));
            result.setResult(calculatedValue);
        }
        return result.getResult();
    }

    public static int getLoopCount(String input) {
        return input.split(" ").length;
    }
}
