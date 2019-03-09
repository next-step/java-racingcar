package calculator;


import java.util.Scanner;

public class StringCalculator {

    static int calculate(String text) {
        String[] values = text.split(" ");
        int resultValue = setFormatMix(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]));
        if (values.length - 1 >= 3)
            for (int i = 3; i < values.length; i += 2) {
                resultValue = setFormatMix(resultValue, values[i], Integer.parseInt(values[i + 1]));
            }
        return resultValue;
    }


    static int setFormatMix(int startNumber, String operation, int endNumber) {
        switch (operation) {
            case "+":
                return add(startNumber, endNumber);
            case "-":
                return sub(startNumber, endNumber);
            case "/":
                return div(startNumber, endNumber);
            case "*":
                return multi(startNumber, endNumber);
        }
        return 0;
    }

    static int add(int i, int j) {
        return i + j;
    }

    static int sub(int i, int j) {
        return i - j;
    }

    static int multi(int i, int i1) {
        return i * i1;
    }

    static int div(int i, int i1) {
        return i / i1;
    }

    static void checkNull(String input) {
        if (input == null || " ".equals(input))
            throw new NullPointerException();
    }

    static int checkNumber(String input) {
        checkNull(input);
        return Integer.parseInt(input);
    }

    public static String start() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
