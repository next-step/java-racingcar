package calculatorFunction;

import java.util.Scanner;

public class GetInput {

    public static String inputString() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return str;
    }

    public static String[] parsing(String expression) {
        // 1 + 3 - 5
        String[] array = new String[100];
        int it = 0;
        int strIt = 0;
        array[it] = getInteger(expression, strIt);
        strIt = array[it].length() + strIt;
        it++;

        while (strIt != expression.length()) {
            array[it++] = getString(expression, strIt);
            array[it++] = String.valueOf(expression.charAt(strIt));
            strIt++;
            array[it] = getInteger(expression, strIt);
            strIt = array[it].length() + strIt;
            it++;
        }

        return array;
    }

    public static String getInteger(String str, int idx) {
        String string = "";
        for (int i = idx; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                string += str.charAt(i);
            } else {
                break;
            }
        }

        if (string.length() == 0) {
            return "ERROR";
        } else if (string.charAt(0) == '0' && string.length() > 1) {
            return "ERROR";
        }

        return string;
    }

    public static String getString(String str, int idx) {
        return String.valueOf(str.charAt(idx));
    }

}
