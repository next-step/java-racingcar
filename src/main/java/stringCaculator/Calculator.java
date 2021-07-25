package stringCaculator;

public class Calculator {
    public static int calculate(String value) {
        String[] values = value.split(" ");

        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[2]);

        return first + second;
    }
}
