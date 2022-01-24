package calculatorFunction;

import java.util.Scanner;

public class GetInput {

    public static String inputString() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replace(" ", "");
        return str;
    }

    public static String[] parsing(String str) {
        // 1 + 3 - 5
        String[] array = new String[100];
        int it = 0;
        int strIt = 0;
        array[it] = getInteger(str, strIt);
        strIt = array[it].length() + strIt;
        it++;

        while (strIt != str.length()) {
            array[it++] = getString(str, strIt);
            strIt++;
            array[it] = getInteger(str, strIt);
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
        return Character.toString(str.charAt(idx));
    }

}
