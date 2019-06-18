package calculator;

public class StringCalculator {

    static int calculate(String input) {
        String[] values = split(input);

        int operand1 = Integer.parseInt(values[0]);
        String operator = values[1];
        int operand2 = Integer.parseInt(values[2]);

        int result = calculate(operand1, operator, operand2);

        for(int i=3, loop = values.length; i < loop; ) {
            operator = values[i++];
            operand2 = Integer.parseInt(values[i++]);
            result = calculate(result, operator, operand2);
        }

        return result;
    }

    static int calculate(int operand1, String operator, int operand2) {
        if(operator.equals("+"))
            return add(operand1, operand2);
        if(operator.equals("-"))
            return subtract(operand1, operand2);
        if(operator.equals("*"))
            return multiply(operand1, operand2);
        if(operator.equals("/"))
            return divide(operand1, operand2);

        return 0;
    }

    static int isBlank(String input) {
        if(input == null || input.isEmpty())
            throw new IllegalArgumentException();
        return 0;
    }

    static String[] split(String text) {
        String[] values = text.split(" ");
        return values;
    }

    static int add(int operand1, int operand2) { return operand1 + operand2; }

    static int subtract(int operand1, int operand2) { return operand1 - operand2; }

    static int multiply(int operand1, int operand2) { return operand1 * operand2; }

    static int divide(int operand1, int operand2) { return operand1 / operand2; }
}
