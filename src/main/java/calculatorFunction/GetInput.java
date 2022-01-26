package calculatorFunction;

import java.util.Scanner;
import java.util.ArrayList;

public class GetInput {

    public static String inputString() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replace(" ", "");
        return str;
    }

    public static ArrayList<String> parsing(String str) {
        ArrayList<String> array = new ArrayList<>();
        int operatorIdx = 0;
        array.add(getInteger(str, operatorIdx));
        operatorIdx = array.get(0).length() + operatorIdx;

        while (operatorIdx != str.length()) {
            array.add(getString(str, operatorIdx));
            operatorIdx++;
            array.add(getInteger(str, operatorIdx));
            operatorIdx = array.get(array.size() - 1).length() + operatorIdx;
        }
        return array;
    }

    public static String getInteger(String str, int idx) {
        StringBuilder string = new StringBuilder();
        for (int i = idx; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                string.append(str.charAt(i));
            } else {
                break;
            }
        }
        if (string.length() == 0) {
            throw new IllegalArgumentException("Error: need right expression");
        } else if (string.charAt(0) == '0' && string.length() > 1) {
            throw new IllegalArgumentException("Error: need right operand");
        }

        return string.toString();
    }

    public static String getString(String str, int idx) {
        return Character.toString(str.charAt(idx));
    }
}
