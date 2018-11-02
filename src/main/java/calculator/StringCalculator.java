package calculator;

public class StringCalculator {
    public int calculator(String text) {

        String[] values = text.split("");
        int first = Integer.parseInt(values[0]);
        int secont = Integer.parseInt(values[2]);
        if (values[1].equals("+")) {
            return first + secont;
        }

        if (values[1].equals("-")) {
            return first - secont;
        }

        if (values[1].equals("*")) {
            return first * secont;
        }

        if (values[1].equals("/")) {
            return first / secont;
        }

        // /Users/hjyoo/Desktop/gradle-4.10.2/bin
        return 0;
    }
}