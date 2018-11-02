package calculator;

public class StringCalculator {
    public static int calculate(String text) {

        String[] values = text.split(" ");
        int result = Integer.parseInt(values[0]);

        for (int i = 0; i <values.length; i++) {
            if (i != 0) {
                if (values[i].equals("+")) {
                } else if (values[i].equals("-")) {
                } else if (values[i].equals("*")) {
                } else if (values[i].equals("/")) {
                } else {

                }
            }

        }

    }

    private static int calculate(String value, int first, int second) {
        if (value.equals("+")) {
            return first + second;
        }

        if (value.equals("-")) {
            return first - second;
        }

        if (value.equals("*")) {
            return first * second;
        }

        if (value.equals("/")) {
            return first / second;
        }

        throw new IllegalArgumentException();
    }
}
