package calculator;

public class Calculator {
    private static final String BLANK = " ";
    
    public static int calculate(String input) {
        String[] inputArray = getInputArray(input);
        CalculatorFormula formula = new CalculatorFormula(inputArray);
        int result = formula.getNumber(0);
        for (int i = 0; i < inputArray.length / 2; i++) {
            result = formula.getOperator(i).calculate(result, formula.getNumber(i+1));
        }
        return result;
    }

    public static String[] getInputArray(String input) {
        return input.split(BLANK);
    }
}
