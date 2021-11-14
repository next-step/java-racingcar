package racingcar.utils;

public class StringUtils {
    private static final String DISTINCTION = ",";

    public static String[] split(String str) {
        return str.split(DISTINCTION);
    }
}
