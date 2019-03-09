package calculator;

import java.util.Scanner;

public class StringCalculator {
    static int calculate(String text) {
        if(text == null || text.length() == 0) {
            return -1;
        }
        String[] values = text.split(" ");
        if(values.length == 0) {
            return -1;
        }
        int firstElement = Integer.parseInt(values[0]);
        int secondElement = 0;
        String expression = "";

        for(int k=1; k<values.length-1; ) {
            expression = values[k++];
            secondElement = Integer.parseInt(values[k++]);
            firstElement = calculating(expression, firstElement, secondElement);
        }

        return firstElement;
    }

    private static Integer calculating(String expression, int i, int j) {
        if(expression.equals("+")) {
            return i + j;
        }
        if(expression.equals("*")) {
            return i * j;
        }
        if(expression.equals("-")) {
            return i - j;
        }
        if(expression.equals("/")) {
            return i / j;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        int result = StringCalculator.calculate(value);
        System.out.println("result = " + result);
    }
}
