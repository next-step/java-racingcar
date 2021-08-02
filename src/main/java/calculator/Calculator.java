package calculator;


import calculator.enumerate.CalculatorType;

public class Calculator {

    static final String STRING_BLANK = " ";

    public boolean isBlank(String input) {
        if (input == null || input.equals(STRING_BLANK) || input.isEmpty()) {
            throw new IllegalArgumentException("IllegalArgumentException..");
        }
        return false;
    }

    public String[] splitBlank(String input) {
        return input.split(STRING_BLANK);
    }

    public int makeResult(String input) {
        if (isBlank(input))
            throw new IllegalArgumentException("IllegalArgumentException..");
        return calculateSplitString(splitBlank(input));
    }

    public int calculateSplitString(String[] str) {
        int result = toInt(str[0]);
        for (int i = 0; i < str.length - 2; i += 2) {
            result = calculate(result, str[i + 1].charAt(0), toInt(str[i + 2]));
        }
        return result;
    }

    public int calculate(int first, char operator, int second) {
        if (operator == CalculatorType.ADDITION.getSymbol())
            return CalculatorType.ADDITION.operate(first, second);
        if (operator == CalculatorType.SUBTRACTION.getSymbol())
            return CalculatorType.SUBTRACTION.operate(first, second);
        if (operator == CalculatorType.MULTIPLICATION.getSymbol())
            return CalculatorType.MULTIPLICATION.operate(first, second);
        if (operator == CalculatorType.DIVISION.getSymbol())
            return CalculatorType.DIVISION.operate(first, second);

        throw new IllegalArgumentException("IllegalArgumentException..");
    }

    private int toInt(String str) {
        return Integer.parseInt(str);
    }

}
