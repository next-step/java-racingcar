package racingcar.v2.utils;

public class StringUtils {

    static public final String DEFAULT_REGEX = ",";
    static public final int DEFAULT_TEXT_SIZE = 4;


    static public boolean isBlank(String str){
        return str.isBlank();
    }

    static public String[] split(String str) {
        return str.split(DEFAULT_REGEX);
    }

    public static boolean isMoreThanFiveLetters(String str) {
        return str.length() > DEFAULT_TEXT_SIZE;
    }
}
