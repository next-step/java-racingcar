package calculator;

public class Calculator {
    public static int calculate(String text) {
        String[] values = text.split(" ");
        int first = Integer.parseInt(values[0]);
        String operator = values[1];
        int second = Integer.parseInt(values[2]);

        return calculate(first, operator, second);
    }



    private static int calculate(int first, String operator, int second) {

        if (operator.equals("+")) {
            return first + second;
        }
        if (operator.equals("-")) {
            return first - second;
        }
        if (operator.equals("*")) {
            return first * second;
        }
        if (operator.equals("/")) {
            valid(second);
            return first / second;
        }
        return 0;
    }



    private static void valid(int second) {
        if (second == 0) {
            throw new IllegalArgumentException("분모는 0이 될 수 없습니다.");
        }
    }
}
