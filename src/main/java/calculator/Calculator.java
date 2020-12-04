package calculator;

public class Calculator {
    private static final String BLANK = " ";
    
    public static int calculate(String input) {
        CalculatorFormula formula = new CalculatorFormula(input);
        int loopCount = getLoopCount(input);
        int result = formula.getNumber(0);
        for (int i = 1; i <= loopCount; i++) {
            result = Operator.getOperator(formula.getOperator(i))
                             .calculate(result, formula.getNumber(i));
        }
        return result;
    }

    public static int getLoopCount(String input) {
        return input.split(BLANK).length / 2;
    }
}
