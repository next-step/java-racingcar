package calculator;


public class Strings {
    // + - / *


    public static boolean isBlank(String input) {
        if(input == null || input.trim().isEmpty()) throw new IllegalArgumentException("input is null or blank");
        else return true;
    }

    public static boolean checkSymbol(String[] splitBlank){
        String pattern = "[\\d\\+\\-\\*\\/]";
        boolean check = false;
        for(int i=0;i<splitBlank.length;i++){
            check = splitBlank[i].matches(pattern);
            if(!check) throw new IllegalArgumentException("symbol error");
        }
        return check;
    }

    public static String[] cutByOperation(String input) {
        String [] strings = input.split("");
        String [] returnString = new String[3];
        for (String s: strings) {
            if (s.equals("+")) {
                returnString[0] = input.substring(0, input.indexOf(s));
                returnString[1] = "+";
                returnString[2] = input.substring(input.indexOf(s)+1, input.length());
                break;
            }
            if (s.equals("-")) {
                returnString[0] = input.substring(0, input.indexOf(s));
                returnString[1] = "-";
                returnString[2] = input.substring(input.indexOf(s)+1, input.length());
                break;
            }
            if (s.equals("*")) {
                returnString[0] = input.substring(0, input.indexOf(s));
                returnString[1] = "*";
                returnString[2] = input.substring(input.indexOf(s)+1, input.length());
                break;
            }
            if (s.equals("/")) {
                returnString[0] = input.substring(0, input.indexOf(s));
                returnString[1] = "/";
                returnString[2] = input.substring(input.indexOf(s)+1, input.length());
                break;
            }
        }
        return returnString;
    }

}
