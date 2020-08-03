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
}
