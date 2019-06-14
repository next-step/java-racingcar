package calculator;

public class StringCalculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public boolean isEmpty(String s) {
        return s == null || "".equals(s.trim());
    }

    public int calculate(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException();
        }

        String[] strings = input.split(" ");
        int result = convertInteger(strings[0]);

        String operator = null;

        for (int i = 1; i < strings.length; i++) {
            if (i % 2 != 0) {
                operator = strings[i];
            }
            if (i % 2 == 0) {
                result = getResult(result, operator, convertInteger(strings[i]));
            }
        }
        return result;
    }

    private int getResult(int result, String operator, int i) {
        return Operator.getOperator(operator).getResult(result, i);
    }

    public int convertInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }
}
