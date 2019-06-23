package racingcar.utils;

public class StringUtil {
    public static String[] splitBySeparator(String separator, String str){
        return str.trim().split("\\s*" + separator + "\\s*");
    }
}
