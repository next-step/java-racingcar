package calculator;

public class StringCalculator {
    public static int calculate(String text) {

        // "2 + 3 - 2 * 7 / 3"
        String[] values = text.split(" ");

        int one = Integer.parseInt(values[0]);
        int two = Integer.parseInt(values[2]);
        int three = Integer.parseInt(values[4]);
        int four = Integer.parseInt(values[6]);
        int five = Integer.parseInt(values[8]);
        int result = 0;

        return calculate(values, one, two, three, four, five, result);
    }

    private static int calculate(String[] values, int one, int two, int three, int four, int five, int result) {
        if (values[1].equals("+")) {
            result = one + two;
        }

        if (values[3].equals("-")) {
            result -= three;
        }

        if (values[5].equals("*")) {
            result *= four;
        }

        if (values[7].equals("/")) {
            result /= five;
        }

        return result;
    }
}
