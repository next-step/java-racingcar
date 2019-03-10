package calculator;

import java.util.Scanner;

public class StringCalculator {

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        int result = stringCalculator.calculate(value);
        System.out.println(result);
    }

    public int calculate(String value) {
        String [] values = value.split(" ");
        String operator = "+";
        int result = 0;

        for (int i = 0, size = values.length; i < size; i++) {
            try {
                if (operator.equals("*")) {
                    result += Integer.parseInt(values[i]);
                }
                if (operator.equals("/")) {
                    result /= Integer.parseInt(values[i]);
                }
                if (operator.equals("+")) {
                    result += Integer.parseInt(values[i]);
                }
                if (operator.equals("-")) {
                    result -= Integer.parseInt(values[i]);
                }
            } catch (NumberFormatException e) {
                operator = values[i];
            }
        }
        return result;
    }
}
