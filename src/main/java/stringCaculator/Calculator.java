package stringCaculator;

public class Calculator {
    public static int calculate(String value) {
        String[] values = value.split(" ");

        int result = 0;

        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[2]);
        String operator = values[1];

        if (operator.equals("+")) {
            result = first + second;
        } else if (operator.equals("-")) {
            result = first - second;
        }

        return result;
    }
}
