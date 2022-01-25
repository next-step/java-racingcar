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
        int it = 0;
        int strIt = 0;
        array[it] = getInteger(expression, strIt);
        if (array[it].equals(ERROR)) {
            return array;
        }
        strIt = array[it].length() + strIt;
        it++;

        while (strIt != expression.length()) {
            String number = String.valueOf(expression.charAt(strIt));
            array[it++] = number;
            strIt++;
            array[it] = getInteger(expression, strIt);
            if (array[it].equals(ERROR)) {
                array[0] = ERROR;
                return array;
            }
            strIt = array[it].length() + strIt;
            it++;
        }

        return array;
    }

    public static String getInteger(String expression, int idx) {
        String number = "";
        final int LENGTH = expression.length();
        for (int i = idx; i < LENGTH; i++) {
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
