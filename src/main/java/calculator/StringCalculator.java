package calculator;

public class StringCalculator {

    public static int calculate(String input) {
        if (input == null || "".equals(input.trim())) {
            throw new IllegalArgumentException();
        }

        String[] stringArray = input.split(" ");
        int result = toInt(stringArray[0]);

        for (int i = 1; i < stringArray.length; i = i + 2) {
            String operator = stringArray[i];
            int operand = toInt(stringArray[i + 1]);
            result = operate(result, operand, operator);
        }
        return result;
    }

    private static int operate(int a, int b, String operator) {
        Operator op = Operator.from(operator);
        return op.operate(a, b);
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }
}
