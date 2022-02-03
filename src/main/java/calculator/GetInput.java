package calculator;

import java.util.Scanner;

public class GetInput {

    private static final String ERROR = "ERROR";

    public static String inputString() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return str;
    }

    public static String[] parsing(String expression) {
        String[] array = new String[100];
        int arrayIterator = 0;
        int expressionIterator = 0;
        array[arrayIterator] = getInteger(expression, expressionIterator);
        if (array[arrayIterator].equals(ERROR)) {
            return array;
        }
        expressionIterator = array[arrayIterator].length() + expressionIterator;
        arrayIterator++;

        while (expressionIterator != expression.length()) {
            String number = String.valueOf(expression.charAt(expressionIterator));
            array[arrayIterator++] = number;
            expressionIterator++;
            array[arrayIterator] = getInteger(expression, expressionIterator);
            if (array[arrayIterator].equals(ERROR)) {
                array[0] = ERROR;
                return array;
            }
            expressionIterator = array[arrayIterator].length() + expressionIterator;
            arrayIterator++;
        }

        return array;
    }

    public static String getInteger(String expression, int idx) {
        String number = "";
        final int EXPRESSION_LENGTH = expression.length();
        for (int i = idx; i < EXPRESSION_LENGTH; i++) {
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                number += expression.charAt(i);
            } else {
                break;
            }
        }

        if (number.length() == 0) {
            return ERROR;
        } else if (number.charAt(0) == '0' && number.length() > 1) {
            return ERROR;
        }

        return number;
    }

//    public static String getString(String str, int idx) {
//        return String.valueOf(str.charAt(idx));
//    }

}
