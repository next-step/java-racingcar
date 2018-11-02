package calculator;

public class StringCalculator {
    public static int calculator(String text) {
        String[] values = text.split(" ");
        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[2]);
        if (values[1].equals("+")) {
            return first + second;
        }
        if (values[1].equals("-")) {
            return first - second;
        }
        if (values[1].equals("*")) {
            return first * second;
        }
        if (values[1].equals("/")) {
            return first / second;
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        System.out.println(StringCalculator.calculator("2 + 3"));
    }
}
