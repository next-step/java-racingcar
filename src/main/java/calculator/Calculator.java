package calculator;

public class Calculator {
    private static final String BLANK = " ";
    
    public int calculate(String input) {
        String[] inputArray = getInputArray(input);
        Numbers numbers = new Numbers(inputArray);
        Operators operators = new Operators(inputArray);
        int result = numbers.get(0);
        for (int i = 0; i < inputArray.length / 2; i++) {
            result = operators.get(i).calculate(result, numbers.get(i+1));
        }
        return result;
    }

    public static String[] getInputArray(String input) {
        return input.split(BLANK);
    }
}
