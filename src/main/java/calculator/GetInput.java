package calculator;

import java.util.Scanner;

public class GetInput {

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
        strIt = array[it].length() + strIt;
        it++;

        while (strIt != expression.length()) {
            array[it++] = String.valueOf(expression.charAt(strIt));
            strIt++;
            array[it] = getInteger(expression, strIt);
            strIt = array[it].length() + strIt;
            it++;
        }

        return array;
    }

    public static String getInteger(String expression, int idx) {
        String number = "";
        for (int i = idx; i < expression.length(); i++) {
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                number += expression.charAt(i);
            } else {
                break;
            }
        }

        if (number.length() == 0) {
            return "ERROR";
        } else if (number.charAt(0) == '0' && number.length() > 1) {
            return "ERROR";
        }

        return number;
    }

    public static String getString(String str, int idx) {
        return String.valueOf(str.charAt(idx));
    }

}
