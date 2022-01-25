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
        String operand = "";
        int operatorIdx = 0;
        operand = getInteger(str, operatorIdx);
        array.add(operand);
        if (operand.equals("ERROR")) {
            return array;
        }
        operatorIdx = array.get(0).length() + operatorIdx;

        while (operatorIdx != str.length()) {
            array.add(getString(str, operatorIdx));
            operatorIdx++;
            operand = getInteger(str, operatorIdx);
            array.add(operand);
            if (operand.equals("ERROR")) {
                return array;
            }
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
            return "ERROR";
        } else if (string.charAt(0) == '0' && string.length() > 1) {
            return "ERROR";
        }

        return string.toString();
    }

    public static String getString(String str, int idx) {
        return Character.toString(str.charAt(idx));
    }

}
