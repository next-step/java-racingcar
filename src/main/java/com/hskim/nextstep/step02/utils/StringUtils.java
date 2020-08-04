package com.hskim.nextstep.step02.utils;

public class StringUtils {

     /*
        https://www.baeldung.com/java-check-string-number
        Check if a string is numeric in java
        3. Using Plain Java
     */

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /*
        https://stackoverflow.com/questions/2255500/can-i-multiply-strings-in-java-to-repeat-sequences
        Multiply String ex) repeat("*", 3) will return ***
     */
    public static String repeat(String with, int count) {
        return new String(new char[count]).replace("\0", with);
    }
}
