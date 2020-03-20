package stringcalculator;

public class StringCalculator {

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
        return -1;
    }
}
