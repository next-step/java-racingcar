package racing.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameUtil {
    public static final int NAME_LIMIT = 5;
    private static final String DELIMITER = ",";

    public static String[] split(String text) {
        String[] carNames = text.split(DELIMITER);

        for (String name : carNames) {
            checkNameValidation(name);
        }

        return carNames;
    }

    public static void checkNameValidation(String name) {
        if (isNullOrEmptyName(name)) {
            throw new IllegalStateException("차 이름은 공백일 수 없습니다.");
        }

        if (isOverNameLimit(name)) {
            throw new IllegalStateException("차 이름은 5글자를 초과할 수 없습니다. 다시 입력하세요.");
        }
    }

    public static boolean isNullOrEmptyName(String name) {
        if (name == null || name.isBlank()) {
            return true;
        }

        return false;
    }

    public static boolean isOverNameLimit(String name) {
        if (name.length() > NAME_LIMIT) {
            return true;
        }

        return false;
    }

}
