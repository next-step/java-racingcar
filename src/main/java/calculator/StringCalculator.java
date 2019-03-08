package calculator;

public class StringCalculator {


    static int calculate(String text) {
        String values[] = text.split(" ");
        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[2]);
        String expression = values[1];

        if (expression.equals("+")) {
            return first + second;
        }
        if (expression.equals("-")) {
            return first - second;
        }
        if (expression.equals("*")) {
            return first * second;
        }
        if (expression.equals("/")) {
            return first / second;
        }

        return 0;
    }

    public static void main(String[] args) {

    }


}
