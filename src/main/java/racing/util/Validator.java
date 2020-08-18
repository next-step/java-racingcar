package racing.util;

public class Validator {
    private static Integer MAX_LENGTH = 5;
    public static boolean validate(String str) {
        if(null == str || str.length() == 0) {
            throw new IllegalArgumentException("이름에는 공백 또는 null이 들어갈 수 없습니다.");
        }
        return str.length()<=MAX_LENGTH?true:false;
    }
}
