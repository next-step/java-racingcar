package racingcar.util;

public class StringUtil {

    public static String[] splitInput(String input) {
        String[] strArr;
        try {
            strArr = input.split(",");
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("빈값이 들어갔습니다.");
        }
        return strArr;
    }

}
