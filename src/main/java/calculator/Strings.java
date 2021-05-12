package calculator;


public class Strings {

    public static boolean isBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("input is null or blank");
        } else {
            return true;
        }
    }

    public static boolean checkSymbol(String[] splitBlank) {
        String pattern = "[\\d\\+\\-\\*\\/]";
        for (int i = 0; i < splitBlank.length; i++) {
            if (splitBlank[i].matches(pattern)) {
                return true;
            }
        }
        throw new IllegalArgumentException("symbol error");

    }

    public static String[] cutByOperation(String input) {
        String[] strings = input.split("");
        String[] returnString = new String[3];
        for (String s : strings) {
            if (s.equals("+")) {
                returnString[0] = input.substring(0, input.indexOf(s));
                returnString[1] = "+";
                returnString[2] = input.substring(input.indexOf(s) + 1, input.length());
                break;
            }
            if (s.equals("-")) {
                returnString[0] = input.substring(0, input.indexOf(s));
                returnString[1] = "-";
                returnString[2] = input.substring(input.indexOf(s) + 1, input.length());
                break;
            }
            if (s.equals("*")) {
                returnString[0] = input.substring(0, input.indexOf(s));
                returnString[1] = "*";
                returnString[2] = input.substring(input.indexOf(s) + 1, input.length());
                break;
            }
            if (s.equals("/")) {
                returnString[0] = input.substring(0, input.indexOf(s));
                returnString[1] = "/";
                returnString[2] = input.substring(input.indexOf(s) + 1, input.length());
                break;
            }
        }
        return returnString;
    }

}
