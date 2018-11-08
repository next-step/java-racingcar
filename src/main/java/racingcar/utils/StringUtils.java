package racingcar.utils;

public class StringUtils {

    private StringUtils() {

    }

    public static String convertToHyphen(int count) {
        return new String(new char[count]).replace("\0", "-");
    }
}
