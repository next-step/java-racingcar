package racing.util;

import java.util.Arrays;

public class Validator {
    private static Integer MAX_LENGTH = 5;

    public static String[] validate(String[] strArr) {
        for(String str:strArr) {
            validate(str);
        }
        return strArr;
    }

    public static void validate(String str) {
        if(null == str || str.length() == 0) {
            throw new IllegalArgumentException("이름에는 공백 또는 null이 들어갈 수 없습니다.");
        }
        if(str.length()>MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5자리까지 가능합니다.");
        }
    }
}
