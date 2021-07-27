package stringCaculator;

public class Calculator {
    public static int calculate(String value) {
        String[] values = value.split(" ");

        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length; i+=2) {
            int first = result;
            int second = Integer.parseInt(values[i + 1]);
            String operator = values[i];

            if (operator.equals("+")) {
                result = first + second;
            } else if (operator.equals("-")) {
                result = first - second;
            } else if (operator.equals("/")) {
                result = first / second;
            } else if (operator.equals("*")) {
                result = first * second;
            }
        }

        return result;
    }
}
