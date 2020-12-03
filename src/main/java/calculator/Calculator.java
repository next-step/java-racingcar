package calculator;

public class Calculator {

    public static void main(String[] args) {
        String input = "2 + 3 * 4 / 2";
        String[] split = input.split(" ");

        long left = stringToLong(split[0]);
        for (int i = 0; i < split.length - 1; i += 2) {
            String operator = split[i + 1];
            long right = stringToLong(split[i + 2]);
            left = calculate(left, right, operator);
            System.out.println(left);
        }

        System.out.println(input + " = " + left);
    }

    private static long stringToLong(String s) {
        return Long.parseLong(s);
    }

    private static long calculate(long left, long right, String operator) {
        if ("+".equals(operator)) {
            return left + right;
        } else if ("-".equals(operator)) {
            return left - right;
        } else if ("/".equals(operator)) {
            return left / right;
        } else if ("*".equals(operator)) {
            return left * right;
        } else {
            throw new IllegalArgumentException("invlaid operator");
        }
    }

}
