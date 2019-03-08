package calculator;


public class StringCalculator {
    static int calculate(String text) {

        String[] values = text.split(" ");

        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[2]);

        String operation = values[1];

        int x = calculate(first, second, operation);

        return 0;
    }

    private static int calculate(int first, int second, String operation) {
        if (operation.equals("+")) {
            return first + second;
        }
        if (operation.equals("-")) {
            return first - second;
        }
        if (operation.equals("*")) {
            return first * second;
        }
        if (operation.equals("/")) {
            return first / second;
        }
        return 0;
    }
}
