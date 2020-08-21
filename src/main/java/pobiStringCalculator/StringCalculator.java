package pobiStringCalculator;

public class StringCalculator {
    public static int calculate(String s) {
        String[] values = s.split(" ");
        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[2]);
        return first + second;

    }
}
