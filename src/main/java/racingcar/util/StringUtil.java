package racingcar.util;

import java.util.Objects;

public class StringUtil {

    public static String[] splitInput(String input) {
        String[] strArr;
        if (isEmpty(input)) {
            throw new IllegalArgumentException("빈값이 들어갔습니다.");
        }
        strArr = input.split(",");
        return strArr;
    }

    private static boolean isEmpty(String text) {
        return Objects.isNull(text) || text.isEmpty();
    }

}
