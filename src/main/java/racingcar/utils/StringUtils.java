package racingcar.utils;

public class StringUtils {

    public static boolean isBlank(String str){
        if (str == null || str.isEmpty() || str.equals("")) {
            return true;
        }
        return false;
    }
}
