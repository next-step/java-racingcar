package calculator;

import java.util.Scanner;

public class StringCalculator {

    public static void main(String[] args) {
        String value = new Scanner(System.in).nextLine();
        int result = new StringCalculator().calculate(value);

        System.out.println(result);
    }

    public int calculate(String text) {
        String [] characters = text.split(" ");
        String operator = "+";
        int result = 0;

        for (String character : characters) {
            try {
                int value = Integer.parseInt(character);

                if (operator.equals("*")) {
                    result = this.multiple(result, value);
                }
                if (operator.equals("/")) {
                    result = this.division(result, value);
                }
                if (operator.equals("+")) {
                    result = this.add(result, value);
                }
                if (operator.equals("-")) {
                    result = this.subtract(result, value);
                }
            } catch (NumberFormatException e) {
                operator = character;
            }
        }
        return result;
    }

    private int add(int result, int value) {
        return result + value;
    }

    private int subtract(int result, int value) {
        return result - value;
    }

    private int division(int result, int value) {
        return result / value;
    }

    private int multiple(int result, int value) {
        return result * value;
    }
}
