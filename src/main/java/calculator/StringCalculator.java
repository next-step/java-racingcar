package calculator;

public class StringCalculator {

    private final static int DEFAULT_VALUE = 0;
    private final static int START_VALUE = 1;
    private final static int INCREMENT_VALUE = 2;

    public boolean isEmpty(String s) {
        return s == null || "".equals(s.trim());
    }

    public int calculate(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException();
        }

        String[] strings = input.split(" ");
        int result = convertInteger(strings[DEFAULT_VALUE]);

        for (int i = START_VALUE; i < strings.length; i+= INCREMENT_VALUE) {
            result = getResult(result, strings[i], convertInteger(strings[i+START_VALUE]));
        }
        return result;
    }

    private int getResult(int num1, String operator, int num2) {
        return Operator.getOperator(operator).getResult(num1, num2);
    }

    public int convertInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }
}
