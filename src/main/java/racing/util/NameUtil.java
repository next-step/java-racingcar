package racing.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameUtil {
    public static final int NAME_LIMIT = 5;
    private static final String DELIMITER = ",";

    public static String[] split(String text) {

        return text.split(DELIMITER);
    }

    public boolean isOverNameLimit(String name) {
        if (name.length() >= NAME_LIMIT) {
            System.out.println("차 이름은 5글자를 초과할 수 없습니다. 다시 입력하세요.\n");
            return true;
        }

        return false;
    }

}
