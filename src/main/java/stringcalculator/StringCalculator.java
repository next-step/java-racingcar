package stringcalculator;

public class StringCalculator {
    private static final int PLUS = 0;
    private static final int MINUS = 1;

    public int add(String expression) {
        int acc = 0;

        String[] values = expression.split(" ");

        for (String s : values) {
            if (!s.equals("+")) {
                acc += Integer.parseInt(s);
            }
        }

        return acc;
    }

    public int minus(String expression) {
        int acc = 0;
        int operation = PLUS;

        String[] values = expression.split(" ");

        for (String s : values) {
            if (s.equals("-")) {
                operation = MINUS;
                continue;
            }
            if (operation == PLUS) {
                acc += Integer.parseInt(s);
            }
            if (operation == MINUS) {
                acc -= Integer.parseInt(s);
            }
        }

        return acc;
    }
}
